package com.graph.locations;

import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import java.util.Set;

/**
 * Created by paul on 3/22/14.
 */

@NodeEntity
public class City {

    @Indexed private String cityName;
    @Fetch @RelatedTo(type = "REGION") private Region region;
}
