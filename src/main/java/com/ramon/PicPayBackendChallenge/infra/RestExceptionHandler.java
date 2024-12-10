package com.ramon.PicPayBackendChallenge.infra;

import com.ramon.PicPayBackendChallenge.exception.TransferExceptionNullFields;
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

}
