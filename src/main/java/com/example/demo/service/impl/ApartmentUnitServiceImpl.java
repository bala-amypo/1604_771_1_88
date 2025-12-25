package com.example.demo.service.impl;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.repository.ApartmentUnitRepository;
import com.example.demo.service.ApartmentUnitService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentUnitServiceImpl implements ApartmentUnitService {

    private final ApartmentUnitRepository repository;

    public ApartmentUnitServiceImpl(ApartmentUnitRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ApartmentUnit> getAllUnits() {
        return repository.findAll();
    }

    @Override
    public ApartmentUnit getUnitById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public ApartmentUnit saveUnit(ApartmentUnit unit) {
        return repository.save(unit);
    }

    @Override
    public void deleteUnit(Long id) {
        repository.deleteById(id);
    }
}
