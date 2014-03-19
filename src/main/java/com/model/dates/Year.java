package com.model.dates;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * Created by paul.gribelyuk on 3/18/14.
 */

@NodeEntity
public class Year {

    @GraphId private Long id;
    @Indexed(unique = true) private int year;


}
