package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.ApartmentUnit;
import com.example.demo.model.User;
import com.example.demo.repository.ApartmentUnitRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ApartmentUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApartmentUnitServiceImpl implements ApartmentUnitService {

    private final ApartmentUnitRepository apartmentRepo;
    private final UserRepository userRepo;

    @Override
    public ApartmentUnit assignUnitToUser(Long userId, ApartmentUnit unit) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new BadRequestException("user not found"));

        unit.setOwner(user);
        ApartmentUnit saved = apartmentRepo.save(unit);
        user.setApartmentUnit(saved);
        return saved;
    }

    @Override
    public ApartmentUnit getUnitByUser(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new BadRequestException("user not found"));

        return apartmentRepo.findByOwner(user)
                .orElseThrow(() -> new BadRequestException("no unit found"));
    }
}
