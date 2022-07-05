package com.consultadd.todo.service;


import com.consultadd.todo.model.Task;
import com.consultadd.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> getTask() {
        return taskRepository.findAll();
    }

    public String createTask(Task task){
        if(taskRepository.existsById(task.getId())){
            return "Id already exist. Please try to use different one.";
        }
        else {
            taskRepository.save(task);
            return "Task created successfully.";
        }
    }

    public String updateTask(Task task){
        if(taskRepository.existsById(task.getId())){
            taskRepository.save(task);
            return "Task updated successfully";
        }
        else {
            return "Desired task not exist.";
        }

    }

    public String deleteTask(Long id){
        if(taskRepository.existsById(id)){
            taskRepository.deleteById(id);
            return "Task deleted successfully";
        }
        else {
            return "Task does not exist.";
        }
    }
}
