package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "facility_id", nullable = false)
  private Facility facility;

  @ManyToOne(optional = false)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Column(nullable = false)
  private LocalDateTime startTime;

  @Column(nullable = false)
  private LocalDateTime endTime;

  @Column(nullable = false)
  private String status = "CONFIRMED";

  public Booking() {}

  public Booking(Long id, Facility facility, User user, LocalDateTime startTime, LocalDateTime endTime, String status) {
    this.id = id;
    this.facility = facility;
    this.user = user;
    this.startTime = startTime;
    this.endTime = endTime;
    this.status = status;
  }

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public Facility getFacility() { return facility; }
  public void setFacility(Facility facility) { this.facility = facility; }

  public User getUser() { return user; }
  public void setUser(User user) { this.user = user; }

  public LocalDateTime getStartTime() { return startTime; }
  public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

  public LocalDateTime getEndTime() { return endTime; }
  public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

  public String getStatus() { return status; }
  public void setStatus(String status) { this.status = status; }
}
