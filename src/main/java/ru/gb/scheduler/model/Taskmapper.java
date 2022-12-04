package ru.gb.scheduler.model;

public class Taskmapper {
    public String map (Task task){
        return String.format("%s,%s,%s,%s,%s,%s,%s,", task.getId(), task.getTitle(), task.getDescription(),
                task.getFullname(), task.getDate(), task.getTime(), task.getDeadline(), task.getPriority());
    }

    public Task map(String line){
        String[] lines = line.split(",");
        System.out.println(lines[7]);
        return new Task(lines[0], lines[1], lines[2], lines[3], lines[4], lines[5], lines[6], lines[7]);
    }
}
