package com.example.MyMenu.exceptions;

import com.example.MyMenu.enums.SocialNetworks;

public class NoAboutBySocialNetworkExc extends RuntimeException{
    public NoAboutBySocialNetworkExc(SocialNetworks socialNetworks) {
        super("There are no socialNetworks as: " + socialNetworks);
    }
}
