package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;

import org.jspecify.annotations.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/facility/{facilityId}/user/{userId}")
    public ResponseEntity<@Nullable Object> createBooking(
            @PathVariable Long facilityId,
            @PathVariable Long userId,
            @RequestBody Booking booking) {

        return ResponseEntity.ok(
                bookingService.createBooking(facilityId, userId, booking)
        );
    }

    @PostMapping("/{bookingId}/cancel")
    public ResponseEntity<@Nullable Object> cancelBooking(@PathVariable Long bookingId) {
        return ResponseEntity.ok(
                bookingService.cancelBooking(bookingId)
        );
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<@Nullable Object> getBooking(@PathVariable Long bookingId) {
        return ResponseEntity.ok(
                bookingService.cancelBooking(bookingId)
        );
    }
}
