package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booking_logs")
public class BookingLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Booking booking;

    private String logMessage;

    private LocalDateTime loggedAt;

    // Required for test t27
    @PrePersist
    public void onCreate() {
        this.loggedAt = LocalDateTime.now();
    }
}
