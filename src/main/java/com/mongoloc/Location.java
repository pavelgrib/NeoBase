package com.mongoloc;

import com.graph.locations.LatLong;
import org.springframework.data.annotation.Id;

/**
 * Created by paul on 3/26/14.
 */
public class Location {

    @Id private String id;

    private Country country;
    private String region;
    private String city;
    private String zipcode;
    private LatLong latlong;
    private IPv4Address minIPAddress;
    private IPv4Address maxIPAddress;

    public Location(Country country, String region, String city,
                    Latlong latlong) {
        this.country = country;
        this.region = region;
        this.city = city;
    }

    public String getCountryName() {
        return country.getName();
    }

    public String getCountryCode() {
        return country.getCountryCode();
    }

    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }
}