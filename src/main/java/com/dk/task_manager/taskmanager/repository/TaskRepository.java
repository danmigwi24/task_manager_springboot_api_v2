package com.dk.task_manager.taskmanager.repository;



import com.dk.task_manager.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(Task.TaskStatus status);

    List<Task> findByTitleContainingIgnoreCase(String title);
}
