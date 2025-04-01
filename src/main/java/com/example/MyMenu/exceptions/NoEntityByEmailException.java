package com.example.MyMenu.exceptions;

public class NoEntityByEmailException extends RuntimeException {
    public NoEntityByEmailException(String email) {
        super("There is no entity with given Email: " + email);
    }
}
