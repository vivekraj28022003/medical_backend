package com.vivek.medical.service;

import com.vivek.medical.model.request.UserRequestDTO;
import com.vivek.medical.model.response.UserResponseDTO;

import java.util.List;

public interface UserService {

    UserResponseDTO createUser(UserRequestDTO dto);
    UserResponseDTO loginUser(String email, String password);
    UserResponseDTO getUserById(String id);
    List<UserResponseDTO> getAllUsers();
}
