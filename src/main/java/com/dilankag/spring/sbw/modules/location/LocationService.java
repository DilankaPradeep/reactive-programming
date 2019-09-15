package com.dilankag.spring.sbw.modules.location;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * LocationService
 */
@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    public Mono<Location> save(Location location) {
        return this.locationRepository.save(location);
    }

    public Flux<Location> findAll() {
        return this.locationRepository.findAll();
    }

}