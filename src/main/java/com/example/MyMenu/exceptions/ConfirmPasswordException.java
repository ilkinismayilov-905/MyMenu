package com.example.MyMenu.exceptions;

public class ConfirmPasswordException extends RuntimeException {
    public ConfirmPasswordException() {
        System.out.println("Passwords are not equal!");
    }
}
