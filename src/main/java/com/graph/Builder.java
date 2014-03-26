package com.graph;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by paul.gribelyuk on 1/3/14.
 * Builds a Neo4j com.graph to study Consumer transaction data
 */
public class Builder {

    private static final String DB_PATH = "C:\\Users\\paul.gribelyuk\\analytics\\data\neo4j\\consumers";
    private static final String USERNAME_KEY = "USERNAME";
    private static final String UNIQUE_ORDERID = "UORDERID";
    private static final String[] ORDER_KEYS = {"MID", "ORDERID", "ZIPCODE", "HOSTNAME", "EMAIL"};
    private static final String[]  TRANS_KEYS = {};

    private GraphDatabaseService graphDb;
    private HashMap<String, Integer> headers;

    public void putNode(Node node) {

    }

    private static enum RelTypes implements RelationshipType
    {
        PLACED_ORDER, CONTAINS_PRODUCT, SOLD_BY, CLICKED_ON, LOCATED_IN, OF_CATEGORY, OF_BUSINESS_MODEL, AT_TIME
    }

    public Builder() {
        graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(DB_PATH);

//        headers = new HashMap<>();
    }

    private void processFile(String filename) {
        Charset set = Charset.forName("UTF-8");
        Path file = FileSystems.getDefault().getPath(filename);
//        try (BufferedReader reader = Files.newBufferedReader(file, set)) {
//            String line = null;
//            line = reader.readLine();
//            processHeaders(line);
//            while ((line = reader.readLine()) != null) {
//                processLine(line);
//            }
//        } catch (IOException x) {
//            System.err.format("IOException: %s%n", x);
//        }
    }

    private void processHeaders(final String headersString) {
        String [] split = headersString.replace(" ", "").split(",");
        int i = 0;
        for ( String s: split) {
            headers.put(s, i);
            i++;
        }
    }

    private void processLine(final String line) {
        String[] split = line.split(",");
        String username = split[headers.get(USERNAME_KEY)];

        HashSet<String> order_values = new HashSet<String>(ORDER_KEYS.length);
        for (String orders_key: ORDER_KEYS) {
            order_values.add( split[headers.get(orders_key)] );
        }

        HashSet<String> trans_values = new HashSet<String>(TRANS_KEYS.length);
        for ( String trans_key: TRANS_KEYS) {
            trans_values.add( split[headers.get(trans_key)] );
        }

        // if TID in com.graph ---> skip
        // else if ORDERID in com.graph
            // if product doesn't exist ---> create Product
            // else create CONTAINS link from Order to Product
        // else if
    }

    private static void registerShutdownHook( final GraphDatabaseService graphDb ) {
        // Registers a shutdown hook for the Neo4j instance so that it
        // shuts down nicely when the VM exits (even if you "Ctrl-C" the
        // running application).
        Runtime.getRuntime().addShutdownHook( new Thread() {
            @Override
            public void run() {
                graphDb.shutdown();
            }
        } );
    }
}
