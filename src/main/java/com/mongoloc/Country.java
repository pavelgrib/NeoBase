package com.mongoloc;

/**
 * Created by paul on 3/26/14.
 */
public class Country {

    private String name, countryCode;

    public Country(String name, String countryCode) {
        this.name = name;
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getName() {
        return name;
    }
}
