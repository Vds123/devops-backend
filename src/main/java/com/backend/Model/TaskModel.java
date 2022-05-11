package com.backend.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("tasks")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskModel {

    @Id
    private String id;

    private String titleTask;

    private String description;
    
    public TaskModel(String titleTask, String description) {
        this.titleTask = titleTask;
        this.description = description;
    }
}
