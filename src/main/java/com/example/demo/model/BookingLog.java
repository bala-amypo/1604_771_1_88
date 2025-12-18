package com.example.demo.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
public class BookingLog {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@ManyToOne
private Booking booking;


private String logMessage;


private LocalDateTime loggedAt;


@PrePersist
public void onCreate() {
this.loggedAt = LocalDateTime.now();
}


public BookingLog() {}


public BookingLog(Long id, Booking booking, String logMessage, LocalDateTime loggedAt) {
this.id = id;
this.booking = booking;
this.logMessage = logMessage;
this.loggedAt = loggedAt;
}


// getters and setters
}