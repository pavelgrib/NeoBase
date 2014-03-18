package model;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import java.util.Collection;
import java.util.List;

/**
 * Created by paul.gribelyuk on 1/31/14.
 */

@NodeEntity
public class Order {
    @GraphId private Long id;

    @Indexed(unique = true) private String orderId;

    public List<Transaction> products() {
        return null;
    }

    public Advertiser advertiser;

    @RelatedTo(type = "CONTAINS") Collection<Product> products;
    @RelatedTo(type = "LOCATION") Collection<Location> locations;

}
