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
    public Facility addFacility(Facility facility) {
        return repo.save(facility);
    }

    @Override
    public Facility getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Facility findByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public List<Facility> getAllFacilities() {
        return repo.findAll();
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
