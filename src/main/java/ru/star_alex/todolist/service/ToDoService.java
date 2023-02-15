package ru.star_alex.todolist.service;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.star_alex.todolist.dto.ToDoDto;
import ru.star_alex.todolist.mapper.ToDoMapper;
import ru.star_alex.todolist.model.ToDo;
import ru.star_alex.todolist.repository.ToDoRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class ToDoService {

  private final ToDoRepository toDoRepository;
  private final ToDoMapper mapper;

  public List<ToDoDto> toDoList() {
    Iterable<ToDo> toDoIterable = toDoRepository.findAll();
    ArrayList<ToDoDto> toDoList = new ArrayList<>();
    for (ToDo toDo : toDoIterable) {
      toDoList.add(mapper.toToDoDto(toDo));
    }
    return toDoList;
  }

  public ToDoDto add(ToDoDto dto) {
    ToDo toDo = toDoRepository.save(mapper.toToDo(dto));
    return mapper.toToDoDto(toDo);
  }


  public ToDoDto getById(int id) {
    ToDo toDo = toDoRepository.findById(id).orElseThrow(RuntimeException::new);
    return mapper.toToDoDto(toDo);
  }


  public void deleteById(int id) {
    toDoRepository.deleteById(id);

  }


  public void deleteAll() {
    toDoRepository.deleteAll();
  }


  public ToDoDto update(ToDoDto dto) {
    ToDo toDo = toDoRepository.save(mapper.toToDo(dto));
    return mapper.toToDoDto(toDo);
  }

  public String index(Model model) {
    Iterable<ToDo> toDoIterable = toDoRepository.findAll();
    ArrayList<ToDo> toDoList = new ArrayList<>();
    for (ToDo toDo : toDoIterable) {
      toDoList.add(toDo);
    }
    model.addAttribute("ToDos", toDoList);
    model.addAttribute("ToDosCount", toDoList.size());
    return "index";
  }
}


