package com.vivek.medical.controller;

import com.vivek.medical.model.request.UserRequestDTO;
import com.vivek.medical.model.response.UserResponseDTO;
import com.vivek.medical.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO dto) {
        return ResponseEntity.ok(userService.createUser(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable String id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

@PostMapping("/login")
        public ResponseEntity<UserResponseDTO> loginUser(@RequestBody UserRequestDTO dto) {
            return ResponseEntity.ok(userService.loginUser(dto.getEmail(), dto.getPassword()));
        }
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
