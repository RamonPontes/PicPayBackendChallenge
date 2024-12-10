package com.ramon.PicPayBackendChallenge.controller;

import com.ramon.PicPayBackendChallenge.dto.TransferRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TransactionController {
    @PostMapping("/transfer")
    public ResponseEntity<?> transfer(@RequestBody TransferRequest transferData) {
        return ResponseEntity.ok(transferData);
    }
}
