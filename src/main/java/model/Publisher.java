package model;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

/**
 * Created by paul.gribelyuk on 1/31/14.
 */

@NodeEntity
public class Publisher {

    @GraphId private Long id;

    @Indexed(unique = true) private int sid;
    private String name;

    @RelatedTo(type = "OF_CATEGORY") PublisherCategory category;
}
