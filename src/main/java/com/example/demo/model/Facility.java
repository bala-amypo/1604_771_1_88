package com.example.demo.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "facilities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Facility {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(unique = true)
private String name;


private String description;


private String openTime;
private String closeTime;
}