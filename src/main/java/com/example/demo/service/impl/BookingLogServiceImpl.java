package com.example.demo.service.impl;

import com.example.demo.model.BookingLog;
import com.example.demo.repository.BookingLogRepository;
import com.example.demo.service.BookingLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingLogServiceImpl implements BookingLogService {

    private final BookingLogRepository bookingLogRepository;

    public BookingLogServiceImpl(BookingLogRepository bookingLogRepository) {
        this.bookingLogRepository = bookingLogRepository;
    }

    @Override
    public BookingLog saveLog(BookingLog log) {
        return bookingLogRepository.save(log);
    }

    @Override
    public List<BookingLog> getAllLogs() {
        return bookingLogRepository.findAll();
    }
}
