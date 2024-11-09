package com.alexjr.tasks.service;

import com.alexjr.tasks.model.Task;
import com.alexjr.tasks.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task createTask(Task task) {
        return repository.save(task);
    }

    public Optional<Task> updateTask(Long id, Task taskDetails) {
        return repository.findById(id).map(task -> {
            task.setTitle(taskDetails.getTitle());
            task.setCompleted(taskDetails.isCompleted());
            return repository.save(task);
        });
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
