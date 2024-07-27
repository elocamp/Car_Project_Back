package com.CarProjectSpring.services.admin;

import com.CarProjectSpring.dto.CarDto;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public interface AdminService {

    boolean postCar(CarDto carDto);

    List<CarDto> getAllCars();

    CarDto getCarById(Long id);

    void deleteCar(long id);

    boolean updateCar(long id, CarDto carDto) throws IOException;
}
