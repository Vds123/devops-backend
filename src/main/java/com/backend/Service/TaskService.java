package com.backend.Service;

import com.backend.Model.TaskModel;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.Repository.TaskRepository;

@Data
@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Iterable<TaskModel> getTasks()
    {
        return taskRepository.findAll();
    }

    public void deleteTask(final Long id) {
        taskRepository.deleteById(id);
    }
}
