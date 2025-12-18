package com.example.demo.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
public class Booking {


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


private String status;


@OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
private List<Booking> logs;


public Booking() {}


public Booking(Long id, Facility facility, User user, LocalDateTime startTime, LocalDateTime endTime, String status) {
this.id = id;
this.facility = facility;
this.user = user;
this.startTime = startTime;
this.endTime = endTime;
this.status = status;
}



}