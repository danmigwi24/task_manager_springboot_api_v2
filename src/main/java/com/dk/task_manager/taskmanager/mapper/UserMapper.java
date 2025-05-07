package com.dk.task_manager.taskmanager.mapper;

import com.dk.task_manager.taskmanager.dto.UserRequestDto;
import com.dk.task_manager.taskmanager.model.User;

public class UserMapper {

    public static User toEntity(UserRequestDto request) {
        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .build();
    }

    public static void updateEntity(User user, UserRequestDto request) {
        user.setName(request.getName());
        user.setEmail(request.getEmail());
    }
}

