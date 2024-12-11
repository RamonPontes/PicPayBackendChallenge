package com.ramon.PicPayBackendChallenge.service;

import com.ramon.PicPayBackendChallenge.exception.UserExceptionDocumentUsing;
import com.ramon.PicPayBackendChallenge.exception.UserExceptionEmailUsing;
import com.ramon.PicPayBackendChallenge.exception.UserExceptionInvalidArgument;
import com.ramon.PicPayBackendChallenge.model.Picpayuser;
import com.ramon.PicPayBackendChallenge.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<Picpayuser> getAllUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred during the transfer process", e);
        }
    }

    public void createUser(Picpayuser userData) {
        try {
            if (userData.hasFieldNull()) { throw new UserExceptionInvalidArgument("All fields must be filled in"); }
            if (userRepository.findByEmail(userData.getEmail()).isPresent()) { throw new UserExceptionEmailUsing("Email already registered"); }
            if (userRepository.findByDocument(userData.getDocument()).isPresent()) { throw new UserExceptionDocumentUsing("Document already registered"); }


            userRepository.save(userData);

        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred during the transfer process", e);
        }
    }
}