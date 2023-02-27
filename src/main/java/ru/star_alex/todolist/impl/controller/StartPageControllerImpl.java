package ru.star_alex.todolist.impl.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.star_alex.todolist.controller.StartPageController;
import ru.star_alex.todolist.service.ToDoService;

@Controller
@RequiredArgsConstructor
@Slf4j
public class StartPageControllerImpl implements StartPageController {

    private final ToDoService toDoService;

    public String index(Model model) {
        return toDoService.index(model);
    }

}
