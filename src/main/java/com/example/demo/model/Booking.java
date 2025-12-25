package com.example.demo.model;

import java.time.LocalDateTime;

public class Booking {
    public static final String STATUS_CONFIRMED = "CONFIRMED";
    public static final String STATUS_CANCELLED = "CANCELLED";

    private Long id;
    private Facility facility;
    private User user;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;

    public Booking(Long id, Facility facility, User user,
                   LocalDateTime startTime, LocalDateTime endTime, String status) {
        this.id = id;
        this.facility = facility;
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public Long getId() { return id; }
    public Facility getFacility(){ return facility; }
    public User getUser(){ return user; }
    public String getStatus(){ return status; }

    public void cancel() {
        this.status = STATUS_CANCELLED;
    }
}
