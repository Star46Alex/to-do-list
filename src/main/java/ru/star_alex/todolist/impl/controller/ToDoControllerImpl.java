package ru.star_alex.todolist.impl.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.star_alex.todolist.controller.ToDoController;
import ru.star_alex.todolist.dto.ToDoDto;
import ru.star_alex.todolist.service.ToDoService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ToDoControllerImpl implements ToDoController {

    private final ToDoService toDoService;

    @Override
    public ResponseEntity<List<ToDoDto>> toDoList() {
        return ResponseEntity.status(HttpStatus.OK).body(toDoService.toDoList());
    }

    @Override
    public ResponseEntity<ToDoDto> add(ToDoDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(toDoService.add(dto));
    }

    @Override
    public ResponseEntity<ToDoDto> getById(int id) {
        return ResponseEntity.status(HttpStatus.OK).body(toDoService.getById(id));
    }


    @Override
    public ResponseEntity dellById(int id) {
        toDoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity dellAll() {
        toDoService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ToDoDto> update(ToDoDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(toDoService.update(dto));
    }
}


