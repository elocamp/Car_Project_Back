package com.CarProjectSpring.services.auth;

import com.CarProjectSpring.dto.SignupRequest;
import com.CarProjectSpring.dto.UserDto;

public interface AuthService {

    UserDto signup(SignupRequest signupRequest);

    Boolean hasUserWithEmail(String email);
}
