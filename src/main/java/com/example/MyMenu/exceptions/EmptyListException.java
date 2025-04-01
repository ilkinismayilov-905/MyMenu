package com.example.MyMenu.exceptions;

public class EmptyListException extends RuntimeException {
    public EmptyListException() {
      System.out.println("This list is empy");
    }
}
