package com.example.demo.service;

import com.example.demo.model.Booking;
import java.util.List;

public interface BookingService {

    List<Booking> getAllBookings();
    Booking getBookingById(Long id);
    Booking saveBooking(Booking booking);
    void deleteBooking(Long id);
}
