package com.model;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

import java.util.Date;

/**
 * Created by paul.gribelyuk on 3/18/14.
 */

@NodeEntity
public class Offer  extends AbstractEntity {

    @Indexed(unique = true) private String offerId;

    private Date startDate;
    private Date endDate;

    private int count;
}
