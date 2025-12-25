package com.example.demo.repository;

import com.example.demo.model.BookingLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingLogRepository extends JpaRepository<BookingLog, Long> {
}
