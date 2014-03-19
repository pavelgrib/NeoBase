package com.model;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.support.index.IndexType;

/**
 * Created by paul.gribelyuk on 1/31/14.
 */

@NodeEntity
public class Product {

    @Indexed(indexType = IndexType.FULLTEXT, indexName = "product") private String name;

    // a map is necessary when multiple merchants sell the same product
    private String sku;

    private ProductCategory category;

    @RelatedTo(type = "SOLD_BY", direction = Direction.OUTGOING) Advertiser seller;
}
