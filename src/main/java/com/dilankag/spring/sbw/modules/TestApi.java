package com.dilankag.spring.sbw.modules;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * TestApi
 */
@RestController
@RequestMapping("/api/")
public class TestApi {

    @GetMapping(value = "hello")
    public String getMethodName() {
        return new String("Hello");
    }

    @GetMapping(value = "bye")
    public String getBuys() {
        return new String("Buy");
    }



}