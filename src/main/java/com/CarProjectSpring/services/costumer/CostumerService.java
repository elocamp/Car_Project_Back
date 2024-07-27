package com.CarProjectSpring.services.costumer;

import com.CarProjectSpring.dto.CarDto;

import java.util.List;

public interface CostumerService {

    List<CarDto> getAllCars();

    CarDto getCarById(Long id);
}
