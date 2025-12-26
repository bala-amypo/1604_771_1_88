package com.example.demo.service;

import com.example.demo.model.Booking;

public interface BookingService {
    Booking createBooking(Long facilityId, Long userId, Booking booking);
    Booking cancelBooking(Long id);
    Booking getBooking(Long id);
    void deleteBooking(Long id); // ⭐ ADD THIS
}
