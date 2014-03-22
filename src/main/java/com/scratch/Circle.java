package com.scratch;

import com.graph.locations.LatLong;

/**
 * Created by paul on 3/22/14.
 */
public class Circle implements Shape {
    private float radius;
    private LatLong center;

    public Circle(float radius, LatLong center) {
        this.radius = radius;
        this.center = center;
    }

    @Override
    public boolean inside(LatLong latlong) {
        return this.center.distance(latlong) < radius;
    }

    @Override
    public float area() {
        return (float) (Math.PI * Math.pow(this.radius, 2));
    }
}
