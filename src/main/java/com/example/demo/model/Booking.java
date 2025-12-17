package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
// 'booking' is often a reserved word in some databases, better to use a plural form
@Table(name = "bookings") 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // id (Long, PK)

    @ManyToOne // facility (ManyToOne)
    private Facility facility;

    @ManyToOne // user (ManyToOne)
    private User user;

    @Column(nullable = false)
    private LocalDateTime startTime; // startTime (LocalDateTime)

    @Column(nullable = false)
    private LocalDateTime endTime; // endTime (LocalDateTime)

    // Rule: Default status: "CONFIRMED"
    @Column(nullable = false)
    private String status = "CONFIRMED"; // status (String)

}
