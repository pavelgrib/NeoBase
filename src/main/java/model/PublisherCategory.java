package model;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * Created by paul.gribelyuk on 3/18/14.
 */

@NodeEntity
public class PublisherCategory {

    @GraphId private Long id;

    private String categoryName;
}
