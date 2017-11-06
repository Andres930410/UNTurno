package com.slabcode.unturno;

/**
 * Created by AndresGutierrez on 06/11/2017.
 */

public class Building {
    private String name;
    private String number;
    private Double lat;
    private Double lng;

    public Building(String name, String number, Double lat, Double lng) {
        this.name = name;
        this.number = number;
        this.lat = lat;
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
