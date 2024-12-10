package com.ramon.PicPayBackendChallenge.exception;

public class TransferExceptionInsufficientBalance extends RuntimeException {
    public TransferExceptionInsufficientBalance(String message) {
        super(message);
    }
}
