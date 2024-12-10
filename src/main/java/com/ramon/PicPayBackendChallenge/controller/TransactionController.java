package com.ramon.PicPayBackendChallenge.controller;

import com.ramon.PicPayBackendChallenge.dto.TransferRequest;
import com.ramon.PicPayBackendChallenge.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transfer")
    public ResponseEntity<?> transfer(@RequestBody TransferRequest transferData) {
        transactionService.transfer(transferData);
        return ResponseEntity.ok("Transfer completed successfully");
    }
}
