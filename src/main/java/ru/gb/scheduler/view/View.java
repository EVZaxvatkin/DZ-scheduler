package ru.gb.scheduler.view;

import ru.gb.scheduler.controller.TaskController;
import ru.gb.scheduler.model.Task;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class View {

    private TaskController taskController;

    public View(TaskController taskController){
        this.taskController=taskController;
    }

    public void run(){
        Command com = Command.NONE;

        while (true){
            String command = prompt("Введите команду: ");
            com = Command.valueOf(command);
            switch (com){
                case CREATE:
                    String title = prompt("Название: ");
                    String description = prompt("Описание: ");
                    String fullname = prompt("Ответственный: ");
                    String date = LocalDate.now().toString();
                    String time = LocalTime.now().toString();
                    String deadline = prompt("Срок исполнения: ");
                    String priority = prompt("Приоритет: ");

                    taskController.saveTask(new Task(title, description, fullname, date, time, deadline, priority));
                    break;

                case READ:
                    String id = prompt("Идентификатор задачи: ");
                    try {
                        Task task = taskController.readTask(id);
                        System.out.println(task);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;

            }
        }
    }

    private String prompt(String message){
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        return in.nextLine();
    }
}
