package com.example.MyMenu.exceptions;

public class NoEntityByNameException extends RuntimeException {
    public NoEntityByNameException(String userName) {
        super("There is no entity with given Name: " + userName);
    }
}
