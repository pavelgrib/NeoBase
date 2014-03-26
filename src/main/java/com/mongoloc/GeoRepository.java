package com.mongoloc;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by paul on 3/26/14.
 */
public interface GeoRepository extends MongoRepository<Location, String> {

    public Location findByLatlong(float latitude, float longitude);
    public List<Location> findByLastName(String lastName);

}
