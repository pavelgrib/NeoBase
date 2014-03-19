package com.graph;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;

/**
 * Created by paul.gribelyuk on 1/31/14.
 */
public class Updater implements Update {

    private Builder graphBuilder;

    public Updater( Builder graph ) {
        this.graphBuilder = graph;
    }

    @Override
    public boolean insertNode(Node node) {
        graphBuilder.putNode( node );
        return true;
    }

    @Override
    public boolean insertRelationship(Node node1, Node node2, RelationshipType type) {
        return false;
    }

//    public
}
