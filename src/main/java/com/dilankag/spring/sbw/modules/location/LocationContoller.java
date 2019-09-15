package com.dilankag.spring.sbw.modules.location;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * LocationContoller
 */
@RestController
@RequestMapping("/api/")
//all final attributes all together build constructor from lombok
@RequiredArgsConstructor
public class LocationContoller {

    private final LocationService locationService;

//    public LocationContoller(LocationService locationService) {
//        this.locationService = locationService;
//    }


    @GetMapping(value = "locations")
    private Flux<Location> getALocation() {
   return this.locationService.findAll();
    }

    @PostMapping("locations")
    private Mono<Location> save(@RequestBody Location location) {
        return this.locationService.save(location);
    }
    

}