package ru.star_alex.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.star_alex.todolist.model.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {

}
