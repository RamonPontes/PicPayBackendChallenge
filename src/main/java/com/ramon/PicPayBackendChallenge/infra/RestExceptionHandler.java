package com.ramon.PicPayBackendChallenge.infra;

import com.ramon.PicPayBackendChallenge.exception.TransferExceptionNullFields;
import com.ramon.PicPayBackendChallenge.exception.TransferExceptionUserNotFound;
import com.ramon.PicPayBackendChallenge.exception.TransferExceptionUserNotPermission;
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

}
