package ru.gb.scheduler.model;

import java.util.ArrayList;
import java.util.List;

public class RepositoryFile implements Repository{
    private Taskmapper mapper = new Taskmapper();
    private Operation fileOperation;

    public RepositoryFile(Operation fileOperation){
        this.fileOperation=fileOperation;
    }

    @Override
    public List<Task> getAllTasks() {
        List<String> lines = fileOperation.readAllLines();
        List<Task> tasks = new ArrayList<>();
        for (String line : lines) {
            tasks.add(mapper.map(line));
        }
        return tasks;
    }

    @Override
    public String CreateTask(Task task) {

        List<Task> tasks = getAllTasks();
        int max = 0;
        for (Task item : tasks) {
            int id = Integer.parseInt(item.getId());
            if (max < id){
                max = id;
            }
        }
        int newId = ++max;
        String id = String.format("%d", newId);
        task.setId(id);
        tasks.add(task);
        List<String> lines = new ArrayList<>();
        for (Task item: tasks) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);
        return id;
    }
}
