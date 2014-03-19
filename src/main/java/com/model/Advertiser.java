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
public class Advertiser {
    @GraphId private Long id;
    @Indexed(unique = true)
    private int mid;
    private String name;

    @RelatedTo(type = "OF_CATEGORY") AdvertiserCategory category;
    @RelatedTo(type = "MADE_OFFER") Collection<Offer> offers;
}
