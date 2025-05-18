package com.vivek.medical.service.impl;

import com.vivek.medical.model.User;
import com.vivek.medical.model.request.UserRequestDTO;
import com.vivek.medical.model.response.UserResponseDTO;
import com.vivek.medical.repository.UserRepository;
import com.vivek.medical.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO dto) {
User user = new User();
user.setName(dto.getName());
user.setEmail(dto.getEmail());
user.setGender(dto.getGender());
user.setDateOfBirth(LocalDate.now());
user.setPassword(dto.getPassword());
        if (userRepo.findByEmail(dto.getEmail()) != null) {
            throw new RuntimeException("Email already exists");
        }
        System.out.println(user.getName());
        user = userRepo.save(user);
        return mapToResponse(user);
    }

    @Override
   public UserResponseDTO loginUser(String email, String password) {
       User user = userRepo.findByEmail(email);
       if (user == null || !user.getPassword().equals(password)) {
           throw new RuntimeException("Invalid email or password");
       }
       return mapToResponse(user);
   }

    @Override
    public UserResponseDTO getUserById(String id) {
        return userRepo.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepo.findAll().stream().map(this::mapToResponse).toList();
    }

    private UserResponseDTO mapToResponse(User user) {
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getGender(), user.getDateOfBirth());
    }
}
