package com.example.demo.service.impl;

import com.example.demo.exception.ConflictException;
import com.example.demo.model.Booking;
import com.example.demo.model.Facility;
import com.example.demo.model.User;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BookingLogService;
import com.example.demo.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepo;
    private final FacilityRepository facilityRepo;
    private final UserRepository userRepo;
    private final BookingLogService logService;

    public BookingServiceImpl(BookingRepository bookingRepo,
                              FacilityRepository facilityRepo,
                              UserRepository userRepo,
                              BookingLogService logService) {
        this.bookingRepo = bookingRepo;
        this.facilityRepo = facilityRepo;
        this.userRepo = userRepo;
        this.logService = logService;
    }

    @Override
    public Booking createBooking(Long facilityId, Long userId, Booking booking) {
        Facility facility = facilityRepo.findById(facilityId).orElseThrow();
        User user = userRepo.findById(userId).orElseThrow();

        boolean conflict = !bookingRepo
                .findByFacilityAndStartTimeLessThanAndEndTimeGreaterThan(
                        facility, booking.getStartTime(), booking.getEndTime())
                .isEmpty();

        if (conflict) {
            throw new ConflictException("Booking conflict!");
        }

        booking.setFacility(facility);
        booking.setUser(user);
        booking.setStatus(Booking.STATUS_CONFIRMED);
        Booking saved = bookingRepo.save(booking);

        logService.addLog(saved.getId(), "Created");
        return saved;
    }

    @Override
    public Booking cancelBooking(Long id) {
        Booking booking = bookingRepo.findById(id).orElseThrow();
        booking.setStatus(Booking.STATUS_CANCELLED);
        bookingRepo.save(booking);
        logService.addLog(id, "Cancelled");
        return booking;
    }

    @Override
    public Booking getBooking(Long id) {
        return bookingRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepo.deleteById(id);
    }

    // ---- Extra methods for controller compatibility ----

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepo.save(booking);
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepo.findById(id).orElse(null);
    }
}
