package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // id (Long, PK)

    @ManyToOne // booking (ManyToOne)
    private Booking booking;

    private String logMessage; // logMessage (String)

    @Column(nullable = false)
    private LocalDateTime loggedAt; // loggedAt (LocalDateTime)

    // Rule: Timestamp auto-generated (@PrePersist)
    @PrePersist
    protected void onCreate() {
        loggedAt = LocalDateTime.now();
    }
}
