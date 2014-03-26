package com.mongoloc;

/**
 * Created by paul on 3/26/14.
 */
public class Region {

    private Country enclosingCountry;
    private String name;

    public Region(Country country, String name) {
        this.enclosingCountry = country;
        this.name = name;
    }

    public Country getEnclosingCountry() {
        return enclosingCountry;
    }

    public String getName() {
        return name;
    }
}
