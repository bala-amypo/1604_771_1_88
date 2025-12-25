package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookingDate;

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private ApartmentUnit apartment;

    public Booking() {}

    public Booking(String bookingDate, ApartmentUnit apartment) {
        this.bookingDate = bookingDate;
        this.apartment = apartment;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBookingDate() { return bookingDate; }
    public void setBookingDate(String bookingDate) { this.bookingDate = bookingDate; }

    public ApartmentUnit getApartment() { return apartment; }
    public void setApartment(ApartmentUnit apartment) { this.apartment = apartment; }
}
