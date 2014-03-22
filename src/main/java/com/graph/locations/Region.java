package com.graph.locations;

import com.model.AbstractEntity;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.support.index.IndexType;

/**
 * Created by paul on 3/22/14.
 */
public class Region extends AbstractEntity {

    @Indexed(indexType = IndexType.FULLTEXT, indexName = "region") private String region;

    @Fetch @RelatedTo(type = "COUNTRY") Country country;
}
