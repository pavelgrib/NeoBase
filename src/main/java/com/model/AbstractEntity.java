package com.model;

import org.springframework.data.neo4j.annotation.GraphId;

/**
 * Created by paul on 3/22/14.
 */
public abstract class AbstractEntity {
    @GraphId private Long id;
}
