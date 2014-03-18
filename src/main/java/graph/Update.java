package graph;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;

/**
 * Created by paul.gribelyuk on 1/31/14.
 */
public interface Update {
    public boolean insertNode( Node node );
    public boolean insertRelationship( Node node1, Node node2, RelationshipType type );
}
