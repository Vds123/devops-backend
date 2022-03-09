package com.backend.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="titleTask")
    private String titleTask;

    @Column(name="description")
    private String description;

    public TaskModel(String titleTask, String description) {
        this.titleTask = titleTask;
        this.description = description;
    }
}
