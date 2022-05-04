package com.backend.Service;

import com.backend.Model.TaskModel;
import org.springframework.beans.factory.annotation.Autowired;
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

    public TaskModel updateTask(long id, TaskModel t){
        TaskModel task = taskRepository.findById(id).orElse(null);
        task.setTitleTask(t.getTitleTask());
        task.setDescription(t.getDescription());
        return taskRepository.save(task);
    }
}
