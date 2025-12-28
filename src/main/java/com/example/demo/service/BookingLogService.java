package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Booking;
import com.example.demo.model.BookingLog;

public interface BookingLogService {

    BookingLog addLog(Booking booking, String message);

    BookingLog addLog(Long bookingId, String message);

    List<BookingLog> getLogsByBooking(Long bookingId);
}
