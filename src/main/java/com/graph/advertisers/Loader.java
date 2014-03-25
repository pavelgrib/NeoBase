package com.graph.advertisers;

import com.csvreader.CsvReader;
import com.model.Advertiser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by paul.gribelyuk on 3/24/2014.
 */

@Service
public class Loader  {

    private final String path;
    private CsvReader reader;
    private ArrayList<String> headers;
    private int numColumns;

    @Autowired private Neo4jTemplate template;

    public Loader(String filePath, boolean hasHeaders) {
        this.path = filePath;
        try {
            this.reader = new CsvReader(this.path);

            if( hasHeaders ) {
                this.readHeaders();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readHeaders() {
        try {
            this.reader.readHeaders();
            this.numColumns = this.reader.getColumnCount();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void importNodes(String filePath) throws FileNotFoundException, IOException, ParseException {
        CsvReader csvreader = new CsvReader(filePath);

        while(csvreader.readRecord()) {
            int mid = Integer.parseInt(csvreader.get(0));
            String name = csvreader.get(1);
            Advertiser advertiser = new Advertiser(mid, name);

            template.save(advertiser);
        }

    }

    public static void main( String[] args ) {

    }

    public String getPath() {
        return path;
    }
}
