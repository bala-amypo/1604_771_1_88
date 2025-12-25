package com.example.demo.model;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "booking_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
loggedAt = LocalDateTime.now();
}
}