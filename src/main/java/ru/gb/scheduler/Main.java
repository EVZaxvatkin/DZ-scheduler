package ru.gb.scheduler;

import ru.gb.scheduler.controller.TaskController;
import ru.gb.scheduler.model.*;
import ru.gb.scheduler.view.View;

public class Main {
    public static void main(String[] args) {

        Operation fileOperation = new FileOperation("board.txt");
        Repository repository = new RepositoryFile(fileOperation);
        TaskController controller = new TaskController(repository);
        View view = new View(controller);
        view.run();
    }
}