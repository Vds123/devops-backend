package com.backend.Controller;

import com.backend.Model.TaskModel;
import com.backend.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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
    public ResponseEntity<Object> addTask(@RequestBody TaskModel task) {
        taskService.addTask(task);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(task.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/task/{id}")
    public TaskModel updateTask(@PathVariable("id") final Long id, @RequestBody TaskModel task){
        return taskService.updateTask(task);
    }
}
