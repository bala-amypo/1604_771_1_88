package com.example.demo.repository;

import com.example.demo.model.ApartmentUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ApartmentUnitRepository extends JpaRepository<ApartmentUnit, Long> {
    boolean existsByUnitNumber(String unitNumber);
    boolean existsByOwnerId(Long ownerId);
}
