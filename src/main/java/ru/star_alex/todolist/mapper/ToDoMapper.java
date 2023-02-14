package ru.star_alex.todolist.mapper;

import org.mapstruct.Mapper;
import ru.star_alex.todolist.dto.ToDoDto;
import ru.star_alex.todolist.model.ToDo;

@Mapper(componentModel = "spring")
public interface ToDoMapper {
ToDoDto toToDoDto (ToDo toDo);
ToDo toToDo(ToDoDto toDoDto);
}
