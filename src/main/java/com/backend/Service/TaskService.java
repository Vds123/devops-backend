package com.backend.Service;

import com.backend.Mapper.TaskMapper;
import com.backend.Model.TaskModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.Repository.TaskRepository;

import java.util.Optional;


@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    private TaskMapper taskMapper;

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

    public TaskModel updateTask(TaskModel t){
        TaskModel task = taskRepository.findById(t.getId()).orElse(null);
        taskMapper.updateTaskFromDto(task, t);
        return taskRepository.save(task);
    }
}
