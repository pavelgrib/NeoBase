package com.mongoloc;

/**
 * Created by paul on 3/26/14.
 */
public class City {

    private Region enclosingRegion;
    private String name;

    public City(Region region, String name) {
        this.enclosingRegion = region;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Region getEnclosingRegion() {
        return enclosingRegion;
    }
}
