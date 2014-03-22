package com.scratch;

import com.graph.locations.LatLong;

/**
 * Created by paul on 3/22/14.
 */
public interface Shape {

    public boolean inside(LatLong latlong);
    public float area();
}
