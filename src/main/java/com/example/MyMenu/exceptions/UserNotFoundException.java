package com.example.MyMenu.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        System.out.println("UserEntity not found");
    }
}
