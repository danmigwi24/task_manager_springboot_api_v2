package com.dk.task_manager.taskmanager.service;

import com.dk.task_manager.taskmanager.dto.UserRequestDto;
import com.dk.task_manager.taskmanager.exception.ResourceNotFoundException;
import com.dk.task_manager.taskmanager.mapper.UserMapper;
import com.dk.task_manager.taskmanager.model.User;
import com.dk.task_manager.taskmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    /*
    public List<User> getAllUsers1() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById1(Long id) {
        return userRepository.findById(id);
    }

    public User createUser1(User user) {
        return userRepository.save(user);
    }

    public Optional<User> updateUser1(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            return userRepository.save(user);
        });
    }

    public boolean deleteUser1(Long id) {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
    }

    */

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    public User createUser(UserRequestDto request) {
        User user = UserMapper.toEntity(request);
        return userRepository.save(user);
    }

    public User updateUser(Long id, UserRequestDto request) {
        User existingUser = getUserById(id); // Reuse method with exception
        UserMapper.updateEntity(existingUser, request);
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        User existingUser = getUserById(id);
        userRepository.delete(existingUser);
    }


}

