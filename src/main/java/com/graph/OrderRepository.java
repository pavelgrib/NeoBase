package com.graph;

import com.model.Order;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by paul.gribelyuk on 3/18/14.
 */

interface OrderRepository extends GraphRepository<Order> {

//    Iterable<Person> findByActorsMoviesActorName(name)
}

