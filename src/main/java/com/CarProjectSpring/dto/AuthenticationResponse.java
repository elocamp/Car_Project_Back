package com.CarProjectSpring.dto;

import com.CarProjectSpring.enums.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {

    private String jwt;

    private Long userId;

    private UserRole userRole;
}
