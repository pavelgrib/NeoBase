package com.mongoloc;

import com.mongodb.Mongo;
import com.mongodb.WriteConcern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

/**
 * Created by paul on 3/26/14.
 */

@Configuration
@ComponentScan
@EnableMongoRepositories
class LoaderApp extends AbstractMongoConfiguration {

    @Autowired
    private List<Converter<?, ?>> converters;

    /*
    * (non-Javadoc)
    * @see org.springframework.data.mongodb.config.AbstractMongoConfiguration#getDatabaseName()
    */
    @Override
    protected String getDatabaseName() {
        return "geo";
    }

    /*
    * (non-Javadoc)
    * @see org.springframework.data.mongodb.config.AbstractMongoConfiguration#mongo()
    */
    @Override
    public Mongo mongo() throws Exception {

        Mongo mongo = new Mongo();
        mongo.setWriteConcern(WriteConcern.SAFE);

        return mongo;
    }

    /*
    * (non-Javadoc)
    * @see org.springframework.data.mongodb.config.AbstractMongoConfiguration#customConversions()
    */
    @Override
    public CustomConversions customConversions() {
        return new CustomConversions(converters);
    }
}