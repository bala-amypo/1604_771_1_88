package com.example.demo.service;

import com.example.demo.model.Booking;
import java.util.List;

public interface BookingService {

    Booking createBooking(Long facilityId, Long userId, Booking booking);
    Booking getBooking(Long id);
    Booking cancelBooking(Long id);
    void deleteBooking(Long id);

    // ⭐ Add these so controller stops failing
    List<Booking> getAllBookings();
    Booking saveBooking(Booking booking);
    Booking getBookingById(Long id);
}
