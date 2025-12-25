package com.example.demo.service;

import com.example.demo.model.ApartmentUnit;
import java.util.List;

public interface ApartmentUnitService {

    List<ApartmentUnit> getAllUnits();
    ApartmentUnit getUnitById(Long id);
    ApartmentUnit saveUnit(ApartmentUnit unit);
    void deleteUnit(Long id);
}
