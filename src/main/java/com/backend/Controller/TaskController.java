package com.backend.Controller;

import com.backend.Model.TaskModel;
import com.backend.Repository.TaskRepository;
import com.backend.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public Iterable<TaskModel> getTasks() {
        return taskService.getTasks();
    }

    @DeleteMapping("/task/{id}")
    public void deleteTask(@PathVariable("id") final Long id) {
        taskService.deleteTask(id);
    }
}
