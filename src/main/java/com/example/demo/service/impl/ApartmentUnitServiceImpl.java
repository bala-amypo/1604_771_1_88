package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ApartmentUnit;
import com.example.demo.model.User;
import com.example.demo.repository.ApartmentUnitRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ApartmentUnitService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ApartmentUnitServiceImpl implements ApartmentUnitService {

  private final ApartmentUnitRepository apartmentUnitRepository;
  private final UserRepository userRepository;

  public ApartmentUnitServiceImpl(ApartmentUnitRepository apartmentUnitRepository, UserRepository userRepository) {
    this.apartmentUnitRepository = apartmentUnitRepository;
    this.userRepository = userRepository;
  }

  @Override
  public ApartmentUnit assignUnitToUser(Long userId, ApartmentUnit unit) {
    if (userId == null) throw new IllegalArgumentException("User id is required");
    if (unit == null) throw new IllegalArgumentException("Apartment unit is required");
    if (!StringUtils.hasText(unit.getUnitNumber())) throw new IllegalArgumentException("Unit number is required");
    if (unit.getFloor() == null || unit.getFloor() < 0) throw new IllegalArgumentException("Floor must be >= 0");

    User user = userRepository.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User not found"));

    if (apartmentUnitRepository.existsByUnitNumber(unit.getUnitNumber())) {
      throw new BadRequestException("Unit number constraint violation");
    }

    unit.setOwner(user);
    ApartmentUnit saved = apartmentUnitRepository.save(unit);
    user.setApartmentUnit(saved);
    userRepository.save(user);
    return saved;
  }

  @Override
  public ApartmentUnit getUnitByUser(Long userId) {
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    return apartmentUnitRepository.findByOwner(user)
        .orElseThrow(() -> new ResourceNotFoundException("Apartment unit not found"));
  }
}
