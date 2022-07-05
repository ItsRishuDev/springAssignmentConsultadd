package com.consultadd.todo.controller;

import com.consultadd.todo.model.Task;
import com.consultadd.todo.repository.TaskRepository;
import com.consultadd.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/task")
    public List<Task> getTasks(){
        List<Task> taskList = taskService.getTask();
        return taskList;
    }

    @PostMapping("/create")
    public String createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @PutMapping("/update")
    public String updateTask(@RequestBody Task task){
        return taskService.updateTask(task);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id){
        return taskService.deleteTask(id);
    }
}
