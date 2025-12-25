package com.example.demo.service;

import com.example.demo.model.BookingLog;
import java.util.List;

public interface BookingLogService {

    List<BookingLog> getAll();
    BookingLog getById(Long id);
    BookingLog save(BookingLog log);
    void delete(Long id);
}
