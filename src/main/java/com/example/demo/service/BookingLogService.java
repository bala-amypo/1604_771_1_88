package com.example.demo.service;

import com.example.demo.model.BookingLog;
import java.util.List;

public interface BookingLogService {
    BookingLog saveLog(BookingLog log);
    List<BookingLog> getAllLogs();
}
