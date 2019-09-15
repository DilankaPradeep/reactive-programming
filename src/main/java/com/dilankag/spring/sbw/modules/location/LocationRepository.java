package com.dilankag.spring.sbw.modules.location;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * LocationRepository
 */
@Repository
public interface LocationRepository extends ReactiveMongoRepository<Location, String> {

}