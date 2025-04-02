package com.example.MyMenu.exceptions;

public class ConfirmPasswordException extends RuntimeException {
    public ConfirmPasswordException() {
        super("Passwords are not equal!");
    }
}
