package com.ramon.PicPayBackendChallenge.controller;

import com.ramon.PicPayBackendChallenge.model.Picpayuser;
import com.ramon.PicPayBackendChallenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        List<Picpayuser> users = userService.getAllUsers();
        return ResponseEntity.status(200).body(users);
    }

}