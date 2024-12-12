package com.ramon.PicPayBackendChallenge.service;

import org.springframework.stereotype.Service;

@Service
public class PermissionsService {
    public boolean hasPermission(int permissions, int permission) {
        return (permissions & permission) != permission;
    }
}
