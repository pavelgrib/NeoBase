package com.mongoloc;

import com.graph.locations.LatLong;

/**
 * Created by paul on 3/26/14.
 */
public class Latlong {

    private float latitude, longitude;

    public Latlong(float latitude, float longitude) {
        assert latitude >= -180. && latitude <= 180.;
        assert longitude >= -90. && longitude <= 90;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }
}
