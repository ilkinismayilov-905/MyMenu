package com.example.MyMenu.exceptions;

public class NoUserBySurnameException extends RuntimeException {
    public NoUserBySurnameException(String surname) {
      super("No user found by surname: " + surname);
    }
}
