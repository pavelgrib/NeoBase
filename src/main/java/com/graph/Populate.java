package com.graph;

import org.neo4j.graphdb.GraphDatabaseService;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by paul.gribelyuk on 3/17/14.
 *
 * A useful class to populate a collection of Nodes into a com.graph database
 */
public class Populate {

    public static final Charset ENCODING = StandardCharsets.UTF_8;
    private int numCols;
    private String[] headers;
    private List<String> data;
    private GraphDatabaseService graphdb;
    private String nodeName;
    private int currentLine;

    public Populate(String path) throws IOException {

        Path filePath = Paths.get(path);
        try {
            this.data = Files.readAllLines(filePath, ENCODING);
            this.headers = this.data.get(0).split(",");
            this.numCols = this.headers.length;
            this.currentLine = 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Populate graphDB(GraphDatabaseService db) {
        this.graphdb = db;
        return this;
    }

    public Populate withNodeColumn(String colname) {
        this.nodeName = colname;
        return this;
    }

    public Populate addProperties(List<String> columns) {

        for ( String colName: columns ) {

        }
        return this;
    }

    public void parseNextLine() throws Exception {
        if ( this.currentLine >= this.data.size() ) {
            throw new Exception("no more lines to parse");
        }
        this.currentLine += 1;
    }

}
