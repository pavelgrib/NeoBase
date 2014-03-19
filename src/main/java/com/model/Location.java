package com.model;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * Created by paul.gribelyuk on 3/17/14.
 */

@NodeEntity
public class Location {

    @GraphId private Long id;

    private double latitude;
    private double longitude;
    private String city;
    private String country;
    private String zipcode;
}
