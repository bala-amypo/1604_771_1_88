package com.example.demo.model;


import jakarta.persistence.*;


@Entity
public class ApartmentUnit {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String unitNumber;


private Integer floor;


@OneToOne
@JoinColumn(name = "owner_id")
private User owner;


public ApartmentUnit() {}


public ApartmentUnit(Long id, String unitNumber, Integer floor, User owner) {
this.id = id;
this.unitNumber = unitNumber;
this.floor = floor;
this.owner = owner;
}

}