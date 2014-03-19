package com.model;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import java.util.Collection;

/**
 * Created by paul.gribelyuk on 1/31/14.
 */

@NodeEntity
public class Order {
    @GraphId
    private Long id;

    @Indexed(unique = true)
    private String orderId;

    public Advertiser advertiser;

    @RelatedTo(type = "CONTAINS") Collection<Product> products;
    @RelatedTo(type = "ORDERED") Consumer consumer;

}
