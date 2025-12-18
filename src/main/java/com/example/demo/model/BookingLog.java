package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class BookingLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    private String logMessage;

    private LocalDateTime loggedAt;

    public BookingLog() {}

    public BookingLog(Long id, Booking booking, String logMessage, LocalDateTime loggedAt) {
        this.id = id;
        this.booking = booking;
        this.logMessage = logMessage;
        this.loggedAt = loggedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }

    public void setLoggedAt(LocalDateTime loggedAt) {
        this.loggedAt = loggedAt;
    }

    @PrePersist
    public void onCreate() {
        this.loggedAt = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingLog that = (BookingLog) o;
        return Objects.equals(id, that.id) && Objects.equals(booking, that.booking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, booking);
    }
}
