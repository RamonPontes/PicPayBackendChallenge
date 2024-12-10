package com.ramon.PicPayBackendChallenge.exception;

public class TransferExceptionUnauthorized extends RuntimeException {
    public TransferExceptionUnauthorized(String message) {
        super(message);
    }
}
