package com.backend.Controller;

import com.backend.Model.TaskModel;
import com.backend.Service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(MockitoExtension.class)
class TaskControllerTest {
    @Autowired
    TestRestTemplate template;

    @InjectMocks
    TaskController taskController;

    @Mock
    TaskService taskService;

    @Test
    void getTasks() {
        TaskModel t1 = new TaskModel("1", "Tache 1", "ca décrit ici");
        TaskModel t2 = new TaskModel("2", "Tache 2", "ca décrit pas ici");
        List<TaskModel> taskModels;
        taskModels = Arrays.asList(t1, t2);

        when(taskService.getTasks()).thenReturn(taskModels);
        List<TaskModel> res = (List<TaskModel>) taskController.getTasks();

        assertNotNull(res, "No data");
    }

    @Test
    void deleteTask() {
        String url = "/task/1";
        ResponseEntity<Void> resp = template.exchange(url, HttpMethod.DELETE, HttpEntity.EMPTY, Void.class);
        assertEquals(HttpStatus.OK, resp.getStatusCode());
    }

    @Test
    void addTask(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        TaskModel task = new TaskModel("1", "NewTask", "TestAdd");

        when(taskService.addTask(any(TaskModel.class))).thenReturn(task);
        ResponseEntity<Object> responseEntity = taskController.addTask(task);

        assertEquals(201, responseEntity.getStatusCodeValue());
        assertEquals("/1", responseEntity.getHeaders().getLocation().getPath());
    }

    @Test
    void updateTask(){

    }
}