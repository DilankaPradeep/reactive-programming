package com.dilankag.spring.sbw.modules.location;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Location
 */
@Getter
@Setter
//to generate empth constructor using lombok
@NoArgsConstructor
//to generate all args constructor using lombok
@AllArgsConstructor
@Document
public class Location {

    @Id
    private String id;

    private Double lat;
    private Double lng;

}