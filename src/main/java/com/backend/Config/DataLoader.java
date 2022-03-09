package com.backend.Config;

import com.backend.Repository.TaskRepository;
import com.backend.Model.TaskModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner initDb(TaskRepository taskRepository){
        return args -> {
            TaskModel t1 = new TaskModel("Tache 1", "ca décrit ici");
            TaskModel t2 = new TaskModel("Tache 2", "ca décrit pas ici");
            taskRepository.save(t1);
            taskRepository.save(t2);
        };
    }
}
