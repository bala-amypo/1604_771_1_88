package com.example.demo.service.impl;

import com.example.demo.exception.ConflictException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.BookingLogService;
import com.example.demo.service.BookingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepo;
    private final FacilityRepository facilityRepo;
    private final UserRepository userRepo;
    private final BookingLogService logService;

    public BookingServiceImpl(BookingRepository b, FacilityRepository f, UserRepository u, BookingLogService l) {
        this.bookingRepo = b; this.facilityRepo = f; this.userRepo = u; this.logService = l;
    }

    @Override
    public Booking createBooking(Long facId, Long userId, Booking b) {
        Facility f = facilityRepo.findById(facId).orElseThrow();
        User u = userRepo.findById(userId).orElseThrow();

        boolean conflict = !bookingRepo
                .findByFacilityAndStartTimeLessThanAndEndTimeGreaterThan(f,
                        b.getStartTime(), b.getEndTime())
                .isEmpty();

        if (conflict) throw new ConflictException("Booking conflict!");

        b.setFacility(f);
        b.setUser(u);
        b.setStatus(Booking.STATUS_CONFIRMED);
        Booking res = bookingRepo.save(b);

        logService.addLog(res.getId(), "Created");
        return res;
    }

    @Override
    public Booking cancelBooking(Long id) {
        Booking b = bookingRepo.findById(id).orElseThrow();
        b.setStatus(Booking.STATUS_CANCELLED);
        bookingRepo.save(b);
        logService.addLog(id,"Cancelled");
        return b;
    }

    @Override
    public Booking getBooking(Long id) {
        return bookingRepo.findById(id).orElseThrow();
    }
}
