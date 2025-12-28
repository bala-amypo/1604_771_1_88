package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.Booking;
import com.example.demo.model.BookingLog;
import com.example.demo.repository.BookingLogRepository;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingLogService;

@Service
public class BookingLogServiceImpl implements BookingLogService {

    private final BookingLogRepository logRepo;
    private final BookingRepository bookingRepo;

    public BookingLogServiceImpl(
            BookingLogRepository logRepo,
            BookingRepository bookingRepo
    ) {
        this.logRepo = logRepo;
        this.bookingRepo = bookingRepo;
    }

    // Used internally
    @Override
    public BookingLog addLog(Booking booking, String message) {

        BookingLog log = new BookingLog();
        log.setBooking(booking);
        log.setLogMessage(message);

        return logRepo.save(log);
    }

    // REQUIRED by TestNG
    @Override
    public BookingLog addLog(Long bookingId, String message) {

        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new BadRequestException("Booking not found"));

        return addLog(booking, message);
    }

    @Override
    public List<BookingLog> getLogsByBooking(Long bookingId) {

        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new BadRequestException("Booking not found"));

        return logRepo.findByBookingOrderByLoggedAtAsc(booking);
    }
}
