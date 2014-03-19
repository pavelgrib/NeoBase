package com.model;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by paul.gribelyuk on 1/31/14.
 */

@NodeEntity
public class Consumer {
    @GraphId private Long id;
    @Indexed(unique = true)
    private long username;

    public HashMap<String, Order> orders() {
        return null;
    }


    public Location location() {
        return null;
    }

    @RelatedTo(type = "CLICKED_ON") Collection<Publisher> clicks;
    @RelatedTo(type = "LOCATION") Collection<Location> locations;
}
