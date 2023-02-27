package ru.star_alex.todolist.dto;

import lombok.Data;

@Data
public class ToDoDto {

    private int id;
    private String name;
    private String description;
    private String date;

}
