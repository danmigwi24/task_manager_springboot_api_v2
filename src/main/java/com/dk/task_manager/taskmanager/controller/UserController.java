package com.dk.task_manager.taskmanager.controller;

import com.dk.task_manager.taskmanager.dto.ApiResponse;
import com.dk.task_manager.taskmanager.dto.UserRequestDto;
import com.dk.task_manager.taskmanager.exception.ResourceNotFoundException;
import com.dk.task_manager.taskmanager.model.User;
import com.dk.task_manager.taskmanager.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;


    @GetMapping
    public ApiResponse<List<User>> getAllUsers() {
        return ApiResponse.success(userService.getAllUsers(), "Fetched all users");
    }

    @GetMapping("/{id}")
    public ApiResponse<User> getUserById(@PathVariable Long id) {
        return ApiResponse.success(userService.getUserById(id), "User found");
    }

    @PostMapping("/create")
    public ApiResponse<User> createUser(@RequestBody @Valid UserRequestDto request) {
        return ApiResponse.success(userService.createUser(request), "User created successfully");
    }

    @PutMapping("/{id}")
    public ApiResponse<User> updateUser(@PathVariable Long id, @RequestBody @Valid UserRequestDto request) {
        return ApiResponse.success(userService.updateUser(id, request), "User updated successfully");
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ApiResponse.success(null, "User deleted successfully");
    }




}
