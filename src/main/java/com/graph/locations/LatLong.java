package com.graph.locations;

import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

/**
 * Created by paul on 3/22/14.
 */

@NodeEntity
public class LatLong {

    private final static double EARTH_RADIUS = 6371.;
    private final static double KM_PER_MILE = 1.60934;

    private float latitude;
    private float longitude;

    @Fetch @RelatedTo(type = "CITY") City city;

    public LatLong(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public float distance(LatLong other) {
        return (float) Math.sqrt(Math.pow(latitude - other.getLatitude(), 2) +
                Math.pow(longitude - other.getLongitude(), 2));
    }

    public double unitSphereDistance(LatLong other) {
        double degrees_to_radians = Math.PI / 180.0;
        // phi = 90 - latitude
        double phi1 = (90.0 - latitude)*degrees_to_radians;
        double phi2 = (90.0 - other.getLatitude())*degrees_to_radians;

        // theta = longitude
        double theta1 = longitude * degrees_to_radians;
        double theta2 = other.getLongitude() * degrees_to_radians;

        // Compute spherical distance from spherical coordinates.

        // For two locations in spherical coordinates
        // (1, theta, phi) and (1, theta, phi)
        // cosine( arc length ) =
        //    sin phi sin phi' cos(theta-theta') + cos phi cos phi'
        // # distance = rho * arc length;

        double co = (Math.sin(phi1) * Math.sin(phi2) * Math.cos(theta1 - theta2) +
                Math.cos(phi1) * Math.cos(phi2));
        double arc = Math.acos(co);

        // Remember to multiply arc by the radius of the earth
        // in your favorite set of units to get length.
        return arc;
    }

    public double earthDistanceInMiles(LatLong other) {
        return EARTH_RADIUS * unitSphereDistance(other);
    }
}
