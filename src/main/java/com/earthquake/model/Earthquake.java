package com.earthquake.model;

public class Earthquake {

    String country;
    String place;
    String magnitude;
    String dateTime;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }



    public Earthquake(String country, String place, String magnitude, String dateTime) {

        this.country = country;
        this.place = place;
        this.magnitude = magnitude;
        this.dateTime = dateTime;


    }

}