package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Booking;
import com.example.demo.model.BookingLog;

public interface BookingLogRepository extends JpaRepository<BookingLog, Long> {

    List<BookingLog> findByBookingOrderByLoggedAtAsc(Booking booking);
}
