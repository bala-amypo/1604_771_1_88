package com.example.demo.controller;

import com.example.demo.model.BookingLog;
import com.example.demo.service.BookingLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking-log")
public class BookingLogController {

    private final BookingLogService service;

    public BookingLogController(BookingLogService service) {
        this.service = service;
    }

    @GetMapping
    public List<BookingLog> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public BookingLog getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public BookingLog create(@RequestBody BookingLog bookingLog) {
        return service.save(bookingLog);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
