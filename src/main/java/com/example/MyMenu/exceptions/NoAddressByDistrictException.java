package com.example.MyMenu.exceptions;

import com.example.MyMenu.enums.AddressDistrict;

public class NoAddressByDistrictException extends RuntimeException {
    public NoAddressByDistrictException(AddressDistrict district) {
        super("There is no address found by district: " + district);
    }
}
