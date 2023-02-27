package ru.star_alex.todolist.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


public interface StartPageController {

    @RequestMapping("/")
    @Operation(summary = "Список дел")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "", content = @Content(mediaType = "")),
            @ApiResponse(responseCode = "400", content = @Content(mediaType = "")),
            @ApiResponse(responseCode = "401", content = @Content(mediaType = "")),
            @ApiResponse(responseCode = "403", content = @Content(mediaType = "")),
            @ApiResponse(responseCode = "500", content = @Content(mediaType = ""))})
    String index(Model model);

}
