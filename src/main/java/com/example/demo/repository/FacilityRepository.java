package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Facility;

public interface FacilityRepository extends JpaRepository<Facility, Long> {


    Optional<Facility> findByName(String name);
}
