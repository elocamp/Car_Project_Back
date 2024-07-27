package com.CarProjectSpring.services.auth;

import com.CarProjectSpring.dto.SignupRequest;
import com.CarProjectSpring.dto.UserDto;
import com.CarProjectSpring.entities.User;
import com.CarProjectSpring.enums.UserRole;
import com.CarProjectSpring.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    @Autowired
    private final UserRepository repository;

    @PostConstruct
    public void createAdminAccount() {
        Optional<User> optionalAdmin = repository.findByUserRole(UserRole.ADMIN);
        if (optionalAdmin.isEmpty()) {
            User admin = new User();
            admin.setName("Admin");
            admin.setEmail("admin@test.com");
            admin.setUserRole(UserRole.ADMIN);
            admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
            repository.save(admin);
            System.out.println("Admin account created succesfully");
        } else {
            System.out.println("Admin account already exist!");
        }
    }

    @Override
    public UserDto signup(SignupRequest signupRequest) {
        User user = new User();
        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setUserRole(UserRole.COSTUMER);
        return repository.save(user).getUserDto();
    }

    @Override
    public Boolean hasUserWithEmail(String email) {
        return repository.findFirstByEmail(email).isPresent();
    }
}
