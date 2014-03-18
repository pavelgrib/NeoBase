package model;

import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import java.util.HashMap;

/**
 * Created by paul.gribelyuk on 1/31/14.
 */

@NodeEntity
public class Product {

    private String name;

    // a map is necessary when multiple merchants sell the same product
    private String sku;

    private ProductCategory category;

    @RelatedTo(type = "SOLD_BY") Advertiser seller;
}
