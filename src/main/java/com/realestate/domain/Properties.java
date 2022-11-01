package com.realestate.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Properties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="properties_id")
     private Long id;


    private String title;


    private String description;


    private Long bedrooms;


    private Long bathrooms;


    private Long garages;


    private Long area;


    private Long price;


    private String location;


    private String address;


    private String country;


    private String city;


    private String distric;


    private LocalDateTime date ;


    private Long likes;


    private Long visitCount;



}
