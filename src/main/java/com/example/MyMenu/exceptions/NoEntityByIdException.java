package com.example.MyMenu.exceptions;

public class NoEntityByIdException extends RuntimeException {
    public NoEntityByIdException(Long Id) {
        super("No entity found by ID: " + Id);
    }
}
