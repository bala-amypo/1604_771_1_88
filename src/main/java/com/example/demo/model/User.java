package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String name;


@Column(unique = true, nullable = false)
private String email;


private String password;


private String role;


@OneToOne(mappedBy = "owner", cascade = CascadeType.ALL)
private ApartmentUnit apartmentUnit;


public User() {}


public User(Long id, String name, String email, String password, String role) {
this.id = id;
this.name = name;
this.email = email;
this.password = password;
this.role = role;
}

}