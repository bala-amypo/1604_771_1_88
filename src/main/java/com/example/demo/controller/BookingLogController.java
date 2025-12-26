package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.model.BookingLog;
import com.example.demo.service.BookingLogService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class BookingLogController {

    private final BookingLogService bookingLogService;

    public BookingLogController(BookingLogService bookingLogService) {
        this.bookingLogService = bookingLogService;
    }

    @PostMapping("/create")
    public BookingLog createLog(@RequestBody Booking booking) {
        BookingLog log = new BookingLog(booking, "CREATED", LocalDateTime.now());
        return bookingLogService.saveLog(log);
    }

    @GetMapping
    public List<BookingLog> getAllLogs() {
        return bookingLogService.getAllLogs();
    }
}
