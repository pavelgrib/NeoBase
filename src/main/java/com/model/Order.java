package com.model;

import com.graph.locations.LatLong;
import org.springframework.data.neo4j.annotation.*;

import java.util.Collection;

/**
 * Created by paul.gribelyuk on 1/31/14.
 */

@NodeEntity
public class Order  extends AbstractEntity {

    @Indexed(unique = true)
    private String orderId;

    public Advertiser advertiser;

    @RelatedTo(type = "CONTAINS") Collection<Product> products;
    @RelatedTo(type = "ORDERED") Consumer consumer;
    @Fetch @RelatedTo(type = "PLACED_FROM") LatLong latlong;

}
