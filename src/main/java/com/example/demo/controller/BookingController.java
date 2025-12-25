package com.example.demo.controller;


import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/bookings")
public class BookingController {


private final BookingService service;


public BookingController(BookingService s){ service=s; }


@PostMapping("/{facilityId}/{userId}")
public ResponseEntity<?> create(@PathVariable Long facilityId,
@PathVariable Long userId,
@RequestBody Booking b){
return ResponseEntity.ok(service.createBooking(facilityId,userId,b));
}


@PutMapping("/cancel/{bookingId}")
public ResponseEntity<?> cancel(@PathVariable Long bookingId){
return ResponseEntity.ok(service.cancelBooking(bookingId));
}


@GetMapping("/{bookingId}")
public ResponseEntity<?> get(@PathVariable Long bookingId){
return ResponseEntity.ok(service.getBooking(bookingId));
}
}