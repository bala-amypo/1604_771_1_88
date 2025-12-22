package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

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

    public ApartmentUnit() {
    }

    // -------- getters & setters --------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnitNumber() {
        return unitNumber;
    }
 
    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }
 
    public Integer getFloor() {
        return floor;
    }
 
    public void setFloor(Integer floor) {
        this.floor = floor;
    }
 
    public User getOwner() {
        return owner;
    }
 
    public void setOwner(User owner) {
        this.owner = owner;
    }
}
 