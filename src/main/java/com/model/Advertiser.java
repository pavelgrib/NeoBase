package com.model;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.support.index.IndexType;

import java.util.Collection;

/**
 * Created by paul.gribelyuk on 1/31/14.
 */

@NodeEntity
public class Advertiser extends AbstractEntity {
    @Indexed(unique = true) private int mid;
    @Indexed(indexType = IndexType.FULLTEXT, indexName = "advertiser") private String name;

    @RelatedTo(type = "OF_CATEGORY") AdvertiserCategory category;
    @RelatedTo(type = "MADE_OFFER") Collection<Offer> offers;

    public Advertiser(int mid, String name) {
        this.mid = mid;
        this.name = name;
    }

    public int getMid() {
        return mid;
    }

    public String getName() {
        return name;
    }
}
