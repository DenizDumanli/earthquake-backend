package com.earthquake.model;

import lombok.Data;

@Data
public class Earthquake {

    String country;
    String place;
    String magnitude;
    String dateTime;

    public Earthquake(String country, String place, String magnitude, String dateTime) {

        this.country = country;
        this.place = place;
        this.magnitude = magnitude;
        this.dateTime = dateTime;


    }

}