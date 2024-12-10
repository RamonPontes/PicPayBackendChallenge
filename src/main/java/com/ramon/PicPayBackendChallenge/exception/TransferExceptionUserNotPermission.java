package com.ramon.PicPayBackendChallenge.exception;

public class TransferExceptionUserNotPermission extends RuntimeException {
    public TransferExceptionUserNotPermission(String message) {
        super(message);
    }
}
