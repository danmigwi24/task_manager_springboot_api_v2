package com.dk.task_manager.taskmanager;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskApiResponseController {

    private final TaskService taskService;

    @GetMapping
    public ApiResponse<List<TaskDTO>> getAllTasks1() {
        return ApiResponse.success(taskService.getAllTasks(), "All tasks retrieved");
    }

    @GetMapping("/{id}")
    public ApiResponse<TaskDTO> getTaskById(@PathVariable Long id) {
        return ApiResponse.success(taskService.getTaskById(id),"Task retrieved");
    }

    @GetMapping("/status/{status}")
    public ApiResponse<List<TaskDTO>> getTasksByStatus(@PathVariable Task.TaskStatus status) {
        return ApiResponse.success(taskService.getTasksByStatus(status), "Tasks retrieved");
    }

    @GetMapping("/search")
    public ApiResponse<List<TaskDTO>> searchTasksByTitle(@RequestParam String title) {
        return ApiResponse.success(taskService.searchTasksByTitle(title), "Tasks retrieved");
    }

    @PostMapping
    public ApiResponse<TaskDTO> createTask(@Valid @RequestBody TaskDTO taskDTO) {
        TaskDTO createdTask = taskService.createTask(taskDTO);
       // return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
        return ApiResponse.success(taskService.createTask(createdTask), "Task created successfully");
    }

    @PutMapping("/{id}")
    public ApiResponse<TaskDTO> updateTask(@PathVariable Long id, @Valid @RequestBody TaskDTO taskDTO) {
        return ApiResponse.success(taskService.updateTask(id, taskDTO), "Task updated");
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ApiResponse.success(null, "Task deleted successfully");
    }
}
