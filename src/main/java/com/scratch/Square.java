package com.scratch;

import com.graph.locations.LatLong;

/**
 * Created by paul on 3/22/14.
 */
public class Square implements Shape {

    private float lowerLeftX, lowerLeftY;
    private float upperRightX, upperRightY;

    @Override
    public boolean inside(LatLong latlong) {
        return (latlong.getLatitude() > lowerLeftX) &&
                (latlong.getLatitude() < upperRightX) &&
                (latlong.getLongitude() > lowerLeftY) &&
                (latlong.getLongitude() < upperRightY);
    }

    @Override
    public float area() {
        return (upperRightX - lowerLeftX) * (upperRightY - lowerLeftY);
    }
}
