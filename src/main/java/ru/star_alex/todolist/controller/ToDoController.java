package ru.star_alex.todolist.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.star_alex.todolist.dto.ToDoDto;


public interface ToDoController {

  @GetMapping("/toDos/")
  @Operation(summary = "Список дел")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "", content = @Content(mediaType = "")),
      @ApiResponse(responseCode = "400", content = @Content(mediaType = "")),
      @ApiResponse(responseCode = "401", content = @Content(mediaType = "")),
      @ApiResponse(responseCode = "403", content = @Content(mediaType = "")),
      @ApiResponse(responseCode = "500", content = @Content(mediaType = ""))})
  ResponseEntity<List<ToDoDto>> toDoList();


  @PostMapping("/toDos/")
  @Operation(summary = "Добавление дела")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Дело успешно добалено", content = @Content(mediaType = "")),
      @ApiResponse(responseCode = "400", content = @Content(mediaType = "")),
      @ApiResponse(responseCode = "401", content = @Content(mediaType = "")),
      @ApiResponse(responseCode = "403", content = @Content(mediaType = "")),
      @ApiResponse(responseCode = "500", content = @Content(mediaType = ""))})
  ResponseEntity<ToDoDto> add(ToDoDto toDoDto);

  @GetMapping("/toDos/{id}")
  @Operation(summary = "")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "", content = @Content(mediaType = "")),
      @ApiResponse(responseCode = "400", content = @Content(mediaType = "")),
      @ApiResponse(responseCode = "401", content = @Content(mediaType = "")),
      @ApiResponse(responseCode = "403", content = @Content(mediaType = "")),
      @ApiResponse(responseCode = "500", content = @Content(mediaType = ""))})
  ResponseEntity<ToDoDto> getById(@PathVariable int id);

  @DeleteMapping("/toDos/{id}")
  @Operation(summary = "")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "", content = @Content(mediaType = "")),
      @ApiResponse(responseCode = "400", content = @Content(mediaType = "")),
      @ApiResponse(responseCode = "401", content = @Content(mediaType = "")),
      @ApiResponse(responseCode = "403", content = @Content(mediaType = "")),
      @ApiResponse(responseCode = "500", content = @Content(mediaType = ""))})
  ResponseEntity dellById(@PathVariable int id);

  @DeleteMapping("/toDos/")
  @Operation(summary = "")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "", content = @Content(mediaType = "")),
      @ApiResponse(responseCode = "400", content = @Content(mediaType = "")),
      @ApiResponse(responseCode = "401", content = @Content(mediaType = "")),
      @ApiResponse(responseCode = "403", content = @Content(mediaType = "")),
      @ApiResponse(responseCode = "500", content = @Content(mediaType = ""))})
  ResponseEntity dellAll();

  @PutMapping("/toDos/{id}")
  @Operation(summary = "")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "", content = @Content(mediaType = "")),
      @ApiResponse(responseCode = "400", content = @Content(mediaType = "")),
      @ApiResponse(responseCode = "401", content = @Content(mediaType = "")),
      @ApiResponse(responseCode = "403", content = @Content(mediaType = "")),
      @ApiResponse(responseCode = "500", content = @Content(mediaType = ""))})
  ResponseEntity<ToDoDto> update(ToDoDto toDoDto);

}

