package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "facilities", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Facility {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String name;

  @Column
  private String description;

  @Column(nullable = false)
  private String openTime; // HH:mm

  @Column(nullable = false)
  private String closeTime; // HH:mm

  public Facility() {}

  public Facility(Long id, String name, String description, String openTime, String closeTime) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.openTime = openTime;
    this.closeTime = closeTime;
  }

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }

  public String getOpenTime() { return openTime; }
  public void setOpenTime(String openTime) { this.openTime = openTime; }

  public String getCloseTime() { return closeTime; }
  public void setCloseTime(String closeTime) { this.closeTime = closeTime; }
}
