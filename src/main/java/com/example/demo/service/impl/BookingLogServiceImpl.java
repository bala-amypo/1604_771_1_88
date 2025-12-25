package com.example.demo.service.impl;

import com.example.demo.model.BookingLog;
import com.example.demo.repository.BookingLogRepository;
import com.example.demo.service.BookingLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingLogServiceImpl implements BookingLogService {

    private final BookingLogRepository repo;

    public BookingLogServiceImpl(BookingLogRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<BookingLog> getAll() {
        return repo.findAll();
    }

    @Override
    public BookingLog getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public BookingLog save(BookingLog log) {
        return repo.save(log);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
