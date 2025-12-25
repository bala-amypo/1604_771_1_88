package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "booking_logs")
public class BookingLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String action;
    private String timestamp;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    public BookingLog() {}

    public BookingLog(String action, String timestamp, Booking booking) {
        this.action = action;
        this.timestamp = timestamp;
        this.booking = booking;
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

    public Booking getBooking() { return booking; }
    public void setBooking(Booking booking) { this.booking = booking; }
}
