package com.example.MyMenu.exceptions;

import com.example.MyMenu.enums.Facilities;

public class NoAboutByFacilitiesException extends RuntimeException {
    public NoAboutByFacilitiesException(Facilities facilities) {
        super("No facilities found as: " + facilities);
    }
}
