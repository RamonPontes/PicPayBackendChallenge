package com.ramon.PicPayBackendChallenge.service;

import com.ramon.PicPayBackendChallenge.dto.TransferRequest;
import com.ramon.PicPayBackendChallenge.exception.*;
import com.ramon.PicPayBackendChallenge.model.Picpayuser;
import com.ramon.PicPayBackendChallenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;


@Service
public class TransactionService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionsService permissionsService;

    public void transfer(TransferRequest transferData) {
        if (transferData.hasFieldNull()) { throw new TransferExceptionNullFields("All fields must be filled in"); }

        if (transferData.getValue().compareTo(BigDecimal.valueOf(0)) <= 0 || transferData.getPayer() <= 0 || transferData.getPayee() <= 0) { throw new TransferExceptionInvalidArgument("Invalid argument"); }

        try {
            Optional<Picpayuser> payer = userRepository.findById(transferData.getPayer());
            Optional<Picpayuser> payee = userRepository.findById(transferData.getPayee());

            if (payee.isEmpty() || payer.isEmpty()) { throw new TransferExceptionUserNotFound("Payer or Payee not found"); }

            Picpayuser payerUser = payer.get();
            Picpayuser payeeUser = payee.get();

            if (!permissionsService.hasPermission(payerUser.getPermissions(), 1)) { throw new TransferExceptionUserNotPermission("Payer is not allowed to transfer money"); }

            if (!permissionsService.hasPermission(payeeUser.getPermissions(), 2)) { throw new TransferExceptionUserNotPermission("Payee is not allowed to receive money transfers"); }

            if (payerUser.getBalance().compareTo(transferData.getValue()) < 0) { throw new TransferExceptionInsufficientBalance("Payer not have balance"); }

            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<?> authorizationResponse = restTemplate.getForEntity("https://util.devi.tools/api/v2/authorize", Map.class);

            if (authorizationResponse.getStatusCode() == HttpStatus.OK) {
                payerUser.setBalance(payerUser.getBalance().subtract(transferData.getValue()));
                payeeUser.setBalance(payeeUser.getBalance().add(transferData.getValue()));

                userRepository.save(payerUser);
                userRepository.save(payeeUser);
            }
        }
        catch (HttpClientErrorException e) {
            throw new TransferExceptionUnauthorized("Unauthorized");
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred during the transfer process", e);
        }
    }
}
