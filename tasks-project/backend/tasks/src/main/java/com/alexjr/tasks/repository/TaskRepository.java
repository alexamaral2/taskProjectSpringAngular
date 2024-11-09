package com.alexjr.tasks.repository;

import com.alexjr.tasks.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
