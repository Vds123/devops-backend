package com.backend.Service;

import com.backend.Model.TaskModel;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import com.backend.Repository.TaskRepository;


@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Iterable<TaskModel> getTasks()
    {
        return taskRepository.findAll();
    }

    public void deleteTask(Long id) {
         taskRepository.deleteById(id);
    }

    public TaskModel addTask(TaskModel task) {
        return taskRepository.save(task);
    }

    public TaskModel updateTask(TaskModel task, Long id) {
        return taskRepository.findById(id)
        .map(t -> {
            t.setTitleTask(task.getTitleTask());
            t.setDescription(task.getDescription());
            return taskRepository.save(t);
        })
                .orElseGet(() -> {
                    task.setId(id);
                    return taskRepository.save(task);
                });
    }
}
