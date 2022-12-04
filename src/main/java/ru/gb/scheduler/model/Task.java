package ru.gb.scheduler.model;

public class Task {

    private String id = "";
    private String title;
    private String description;
    private String date;
    private String time;
    private String deadline;
    private String fullname;
    private String priority;

    public Task(String title, String description, String date, String time, String deadline, String fullname, String priority){
        this.title=title;
        this.description=description;
        this.date=date;
        this.time=time;
        this.deadline=deadline;
        this.fullname=fullname;
        this.priority=priority;
    }

    public Task(String id, String title, String description, String date, String time, String deadline, String fullname, String priority){
        this(title, description, fullname, date, time, deadline, priority);
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return String.format("Идентафикатор: %s\nЗаголовок: %s,\nОписание: %s,\nОтветственный: %s\nДата: %s\n" +
                "Время: %s\nДедлайн: %s\nПриоритет: %s", id, title, description, fullname, date, time, deadline, priority);
    }
}
