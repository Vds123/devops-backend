package com.backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
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

    public TaskModel(long id, String titleTask, String description) {
        this.id = id;
        this.titleTask = titleTask;
        this.description = description;
    }

    public String getTitleTask() {
        return titleTask;
    }

    public void setTitleTask(String titleTask) {
        this.titleTask = titleTask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
