package com.CarProjectSpring.services.admin;

import com.CarProjectSpring.dto.CarDto;
import com.CarProjectSpring.entities.Car;
import com.CarProjectSpring.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    @Autowired
    private final CarRepository carRepository;

    @Override
    public boolean postCar(CarDto carDto) {
        try {
            Car car = new Car();
            car.setName(carDto.getName());
            car.setBrand(carDto.getBrand());
            car.setColor(carDto.getColor());
            car.setPrice(carDto.getPrice());
            car.setYear(carDto.getYear());
            car.setType(carDto.getType());
            car.setDescription(carDto.getDescription());
            car.setTransmission(carDto.getTransmission());

            if (carDto.getImage() != null && !carDto.getImage().isEmpty()) {
                car.setImage(carDto.getImage().getBytes());
            }

            carRepository.save(car);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream().map(Car::getCarDto).collect(Collectors.toList());

    }

    @Override
    public CarDto getCarById(Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        return optionalCar.map(Car::getCarDto).orElse(null);
    }

    @Override
    public void deleteCar(long id) {
        carRepository.deleteById(id);
    }

    @Override
    public boolean updateCar(long id, CarDto carDto) throws IOException {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            if (carDto.getImage() != null) {
                car.setImage(carDto.getImage().getBytes());
            }
            car.setName(carDto.getName());
            car.setBrand(carDto.getBrand());
            car.setType(carDto.getType());
            car.setTransmission(carDto.getTransmission());
            car.setColor(carDto.getColor());
            car.setYear(carDto.getYear());
            car.setPrice(carDto.getPrice());
            car.setDescription(carDto.getDescription());
            carRepository.save(car);
            return true;
        }
        return false;
    }
}
