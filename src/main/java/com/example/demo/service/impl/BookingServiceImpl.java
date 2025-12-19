package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ConflictException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BookingLogService;
import com.example.demo.service.BookingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

  private final BookingRepository bookingRepository;
  private final FacilityRepository facilityRepository;
  private final UserRepository userRepository;
  private final BookingLogService bookingLogService;

  public BookingServiceImpl(
      BookingRepository bookingRepository,
      FacilityRepository facilityRepository,
      UserRepository userRepository,
      BookingLogService bookingLogService
  ) {
    this.bookingRepository = bookingRepository;
    this.facilityRepository = facilityRepository;
    this.userRepository = userRepository;
    this.bookingLogService = bookingLogService;
  }

  @Override
  public Booking createBooking(Long facilityId, Long userId, Booking booking) {
    if (facilityId == null || userId == null) throw new IllegalArgumentException("facilityId and userId are required");
    if (booking == null) throw new IllegalArgumentException("Booking body is required");
    if (booking.getStartTime() == null || booking.getEndTime() == null) {
      throw new IllegalArgumentException("Start and end time are required");
    }
    if (!booking.getEndTime().isAfter(booking.getStartTime())) {
      throw new BadRequestException("End time must be greater than start time");
    }

    Facility facility = facilityRepository.findById(facilityId)
        .orElseThrow(() -> new ResourceNotFoundException("Facility not found"));
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User not found"));

    List<Booking> overlaps = bookingRepository
        .findByFacilityAndStartTimeLessThanAndEndTimeGreaterThan(
            facility,
            booking.getEndTime(),
            booking.getStartTime()
        );
    if (!overlaps.isEmpty()) {
      throw new ConflictException("Facility booking conflict detected");
    }

    booking.setFacility(facility);
    booking.setUser(user);
    if (booking.getStatus() == null || booking.getStatus().isBlank()) {
      booking.setStatus("CONFIRMED");
    }

    Booking saved = bookingRepository.save(booking);
    bookingLogService.addLog(saved.getId(), "Booking created");
    return saved;
  }

  @Override
  public Booking cancelBooking(Long bookingId) {
    Booking booking = bookingRepository.findById(bookingId)
        .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));
    booking.setStatus("CANCELLED");
    Booking saved = bookingRepository.save(booking);
    bookingLogService.addLog(saved.getId(), "Booking cancelled");
    return saved;
  }

  @Override
  public Booking getBooking(Long bookingId) {
    return bookingRepository.findById(bookingId)
        .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));
  }
}
