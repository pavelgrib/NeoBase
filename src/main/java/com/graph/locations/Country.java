package com.graph.locations;

import com.model.AbstractEntity;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

import java.util.Set;

/**
 * Created by paul on 3/22/14.
 */

@NodeEntity
public class Country extends AbstractEntity {

    @Indexed(unique = true) private String countryName;
}
