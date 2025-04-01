package com.example.MyMenu.exceptions;

public class NoEntityByTitleEcxeption extends RuntimeException {
    public NoEntityByTitleEcxeption(String title) {
        super("There is no entity found by this Title: " + title);
    }
}
