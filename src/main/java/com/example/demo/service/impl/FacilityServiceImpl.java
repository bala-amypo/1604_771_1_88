package com.example.demo.service.impl;

import com.example.demo.model.Facility;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.service.FacilityService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository repo;

    public FacilityServiceImpl(FacilityRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Facility> getAll() {
        return repo.findAll();
    }

    @Override
    public Facility getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Facility save(Facility facility) {
        return repo.save(facility);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
