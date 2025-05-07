package com.dk.task_manager.taskmanager.repository;

import com.dk.task_manager.taskmanager.model.Task;
import com.dk.task_manager.taskmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
