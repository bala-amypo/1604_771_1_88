package com.example.demo.controller;


import com.example.demo.service.BookingLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/logs")
public class BookingLogController {


private final BookingLogService service;


public BookingLogController(BookingLogService s){ service=s; }


@GetMapping("/booking/{bookingId}")
public ResponseEntity<?> logs(@PathVariable Long bookingId){
return ResponseEntity.ok(service.getLogsByBooking(bookingId));
}
}