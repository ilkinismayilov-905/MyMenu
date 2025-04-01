package com.example.MyMenu.exceptions;

public class NoUserByNameException extends RuntimeException {
    public NoUserByNameException(String name) {
        super("No user found by name: " + name);
    }
}
