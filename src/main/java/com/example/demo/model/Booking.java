package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking {

    // Constants explicitly referenced in tests
    public static final String STATUS_CONFIRMED = "CONFIRMED";
    public static final String STATUS_CANCELLED = "CANCELLED";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Facility facility;

    @ManyToOne
    private User user;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    // Default required by t26
    private String status = STATUS_CONFIRMED;
}
