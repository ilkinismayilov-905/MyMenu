package com.example.MyMenu.exceptions;

public class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException() {
        System.out.println("Restaurant not found");
    }
}
