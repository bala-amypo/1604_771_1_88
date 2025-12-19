package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.Facility;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.service.FacilityService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class FacilityServiceImpl implements FacilityService {

  private final FacilityRepository facilityRepository;
  private static final DateTimeFormatter TIME_FMT = DateTimeFormatter.ofPattern("HH:mm");

  public FacilityServiceImpl(FacilityRepository facilityRepository) {
    this.facilityRepository = facilityRepository;
  }

  @Override
  public Facility addFacility(Facility facility) {
    if (facility == null) throw new IllegalArgumentException("Facility cannot be null");
    if (!StringUtils.hasText(facility.getName())) throw new IllegalArgumentException("Name is required");
    if (!StringUtils.hasText(facility.getOpenTime())) throw new IllegalArgumentException("Open time is required");
    if (!StringUtils.hasText(facility.getCloseTime())) throw new IllegalArgumentException("Close time is required");

    if (facilityRepository.findByName(facility.getName()).isPresent()) {
      throw new BadRequestException("Facility name duplicate");
    }

    LocalTime open;
    LocalTime close;
    try {
      open = LocalTime.parse(facility.getOpenTime(), TIME_FMT);
      close = LocalTime.parse(facility.getCloseTime(), TIME_FMT);
    } catch (DateTimeParseException e) {
      throw new BadRequestException("Invalid time format time");
    }

    if (!open.isBefore(close)) {
      throw new BadRequestException("Open time must be less than close time");
    }

    return facilityRepository.save(facility);
  }

  @Override
  public List<Facility> getAllFacilities() {
    return facilityRepository.findAll();
  }
}
