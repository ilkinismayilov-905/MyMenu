package com.example.MyMenu.exceptions;

import com.example.MyMenu.enums.AddressCity;

public class NoAddressByCityException extends RuntimeException {
    public NoAddressByCityException(AddressCity city) {
        super("There is No Address Found By City: " + city);
    }
}
