package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime; // Consider using LocalTime for robust time handling

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // id (Long, PK)

    @Column(unique = true, nullable = false)
    private String name; // name (String, unique)

    private String description; // description

    // Although specified as String HH:mm, LocalTime provides better rule enforcement capabilities
    private LocalTime openTime; // openTime (String HH:mm -> LocalTime)
    
    private LocalTime closeTime; // closeTime (String HH:mm -> LocalTime)

    // Rule: Open time < Close time. 
    // This validation must be implemented in a service layer or via a custom Bean Validation constraint 
    // to compare the two fields before persisting or updating the entity.
}
