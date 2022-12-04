package ru.gb.scheduler.controller;

import ru.gb.scheduler.model.Repository;
import ru.gb.scheduler.model.Task;

import java.util.List;

public class TaskController {
    private final Repository repository;

    public TaskController(Repository repository){
        this.repository=repository;

    }

    public void saveTask(Task task){
        repository.CreateTask(task);
    }

    public Task readTask(String taskID) throws Exception{
        List<Task> tasks = repository.getAllTasks();
        for (Task task : tasks){
            if(task.getId().equals(taskID)){
                return task;
            }
        }
        throw new Exception("Task not found");
    }
}
