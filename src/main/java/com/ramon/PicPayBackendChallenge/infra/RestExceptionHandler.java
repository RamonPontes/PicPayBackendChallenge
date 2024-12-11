package com.ramon.PicPayBackendChallenge.infra;

import com.ramon.PicPayBackendChallenge.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TransferExceptionNullFields.class)
    private ResponseEntity<String> transferExceptionNullFields(TransferExceptionNullFields exception) {
        return ResponseEntity.status(400).body(exception.getMessage());
    }

    @ExceptionHandler(TransferExceptionUserNotFound.class)
    private ResponseEntity<String> transferExceptionUserNotFound(TransferExceptionUserNotFound exception) {
        return ResponseEntity.status(404).body(exception.getMessage());
    }

    @ExceptionHandler(TransferExceptionUserNotPermission.class)
    private ResponseEntity<String> transferExceptionUserNotPermission(TransferExceptionUserNotPermission exception) {
        return ResponseEntity.status(403).body(exception.getMessage());
    }

    @ExceptionHandler(TransferExceptionInvalidArgument.class)
    private ResponseEntity<String> transferExceptionInvalidArgument(TransferExceptionInvalidArgument exception) {
        return ResponseEntity.status(400).body(exception.getMessage());
    }

    @ExceptionHandler(TransferExceptionInsufficientBalance.class)
    private ResponseEntity<String> transferExceptionInsufficientBalance(TransferExceptionInsufficientBalance exception) {
        return ResponseEntity.status(403).body(exception.getMessage());
    }

    @ExceptionHandler(TransferExceptionUnauthorized.class)
    private ResponseEntity<String> transferExceptionUnauthorized(TransferExceptionUnauthorized exception) {
        return ResponseEntity.status(403).body(exception.getMessage());
    }

    @ExceptionHandler(UserExceptionInvalidArgument.class)
    private ResponseEntity<String> userExceptionInvalidArgument(UserExceptionInvalidArgument exception) {
        return ResponseEntity.status(400).body(exception.getMessage());
    }

}
