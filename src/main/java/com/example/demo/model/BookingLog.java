package com.example.demo.model;
import jakarta.persistence.*;


import java.time.LocalDateTime;
@Entity
public class BookingLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Booking booking;
    private String logMessage;
    private LocalDateTime loggedAt;

    public BookingLog(Long id, Booking booking, String message, LocalDateTime loggedAt){
        this.id=id;
        this.booking=booking;
        this.logMessage=message;
        this.loggedAt=loggedAt;
    }

    public void setLogMessage(String message){ this.logMessage = message; }
    public String getLogMessage(){ return this.logMessage; }
    public LocalDateTime getLoggedAt(){ return this.loggedAt; }

    public void onCreate(){
        this.loggedAt = LocalDateTime.now();
    }
}
