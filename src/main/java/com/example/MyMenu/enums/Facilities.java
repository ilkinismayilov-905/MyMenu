package com.example.MyMenu.enums;

public enum Facilities {
    FREE_WIFI("Free Wi-Fi"),
    OUTDOOR_SEATING("Outdoor Seating"),
    PARKING("Parking"),
    DELIVERY("Delivery"),
    PET_FRIENDLY("Pet Friendly"),
    LIVE_MUSIC("Live Music"),
    WHEELCHAIR_ACCESSIBLE("Wheelchair Accessible"),
    KIDS_FRIENDLY("Kids Friendly"),
    VEGAN_OPTIONS("Vegan Options");

    private final String facilityDescription;

    Facilities(String facilityDescription) {
        this.facilityDescription = facilityDescription;
    }

    public String getFacilityDescription() {
        return facilityDescription;
    }
}
