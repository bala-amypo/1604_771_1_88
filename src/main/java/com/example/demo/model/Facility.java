package com.example.demo.model;


import jakarta.persistence.*;


@Entity
public class Facility {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(unique = true)
private String name;


private String description;


private String openTime;


private String closeTime;


public Facility() {}


public Facility(Long id, String name, String description, String openTime, String closeTime) {
this.id = id;
this.name = name;
this.description = description;
this.openTime = openTime;
this.closeTime = closeTime;
}



}