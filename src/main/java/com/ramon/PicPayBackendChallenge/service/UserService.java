package com.ramon.PicPayBackendChallenge.service;

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
}