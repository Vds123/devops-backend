package com.backend.Controller;

import com.backend.Model.TaskModel;
import com.backend.Repository.TaskRepository;
import com.backend.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
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

    @PostMapping("/task")
    public TaskModel addTask(@RequestBody TaskModel task) {
        return taskService.addTask(task);
    }

    @PutMapping("/task/{id}")
    public TaskModel updateTask(@PathVariable("id") Long id, @RequestBody TaskModel task){
        return taskService.updateTask(task, id);
    }
}
