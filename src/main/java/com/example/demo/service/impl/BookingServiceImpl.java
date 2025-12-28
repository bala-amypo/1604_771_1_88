package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ConflictException;
import com.example.demo.model.Booking;
import com.example.demo.model.Facility;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BookingLogService;
import com.example.demo.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepo;
    private final FacilityRepository facilityRepo;
    private final UserRepository userRepo;
    private final BookingLogService logService;

    public BookingServiceImpl(
            BookingRepository bookingRepo,
            FacilityRepository facilityRepo,
            UserRepository userRepo,
            BookingLogService logService
    ) {
        this.bookingRepo = bookingRepo;
        this.facilityRepo = facilityRepo;
        this.userRepo = userRepo;
        this.logService = logService;
    }

    @Override
    public Booking createBooking(Long userId, Long facilityId, Booking booking) {

        Facility facility = facilityRepo.findById(facilityId)
                .orElseThrow(() -> new BadRequestException("Facility not found"));

        // 🔥 REQUIRED: set facility BEFORE conflict check
        booking.setFacility(facility);

        List<Booking> conflicts =
                bookingRepo.findByFacilityAndStartTimeLessThanAndEndTimeGreaterThan(
                        facility,
                        booking.getEndTime(),
                        booking.getStartTime()
                );

        if (!conflicts.isEmpty()) {
            throw new ConflictException("Booking conflict");
        }

        booking.setStatus("CONFIRMED");
        Booking saved = bookingRepo.save(booking);

        logService.addLog(saved, "BOOKING_CREATED");

        return saved;
    }

    @Override
    public Booking cancelBooking(Long bookingId) {

        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new BadRequestException("Booking not found"));

        booking.setStatus("CANCELLED");
        Booking saved = bookingRepo.save(booking);

        logService.addLog(saved, "BOOKING_CANCELLED");

        return saved;
    }

    @Override
    public Booking getBooking(Long bookingId) {
        return bookingRepo.findById(bookingId)
                .orElseThrow(() -> new BadRequestException("Booking not found"));
    }
}
