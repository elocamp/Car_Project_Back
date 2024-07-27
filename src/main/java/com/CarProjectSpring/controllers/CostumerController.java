package com.CarProjectSpring.controllers;

import com.CarProjectSpring.dto.CarDto;
import com.CarProjectSpring.services.costumer.CostumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/costumer")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CostumerController {

    @Autowired
    private final CostumerService costumerService;

    @GetMapping("/cars")
    public ResponseEntity<List<CarDto>> getAllCars() {
        return ResponseEntity.ok(costumerService.getAllCars());
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable Long id) {
        return ResponseEntity.ok(costumerService.getCarById(id));
    }
}
