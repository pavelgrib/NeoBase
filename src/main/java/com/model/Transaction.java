package com.model;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

import java.util.Date;

/**
 * Created by paul.gribelyuk on 3/17/14.
 */

@RelationshipEntity(type = "ITEMS")
public class Transaction {
    @StartNode Order order;
    @EndNode Product product;

    @Indexed(unique = true) private long tid;
    private Money price;
    private Date transactionDate;
}
