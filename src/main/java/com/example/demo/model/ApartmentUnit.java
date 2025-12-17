package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApartmentUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK

    @Column(unique = true, nullable = false)
    private String unitNumber; // Unique rule applied via @Column

    @Min(value = 0, message = "Floor must be greater than or equal to 0") // Rule: Floor >= 0
    @Column(nullable = false)
    private Integer floor;

    @OneToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id") // Standard JPA mapping for OneToOne
    private User owner; // OneToOne User

}
