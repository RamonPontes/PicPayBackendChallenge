package com.ramon.PicPayBackendChallenge.service;

public class PermissionsService {
    public boolean hasPermission(int permissions, int permission) {
        return (permissions & permission) == permission;
    }
}
