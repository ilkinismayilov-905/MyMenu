package com.example.MyMenu.enums;

public enum SocialNetworks {
    FACEBOOK("Facebook"),
    TWITTER("Twitter"),
    INSTAGRAM("Instagram"),
    LINKEDIN("LinkedIn"),
    SNAPCHAT("Snapchat"),
    TIKTOK("TikTok"),
    YOUTUBE("YouTube"),
    PINTEREST("Pinterest"),
    REDDIT("Reddit"),
    WHATSAPP("WhatsApp");

    private final String networkName;

    SocialNetworks(String networkName) {
        this.networkName = networkName;
    }

    public String getNetworkName() {
        return networkName;
    }
}
