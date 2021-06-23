package com.example.services.controller;

import com.example.services.entity.ToDoEntity;
import com.example.services.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    @PostMapping
    public ResponseEntity createNewToDo(@RequestBody ToDoEntity toDoEntity,
                                        @RequestParam Long userId) {

        try {
            return ResponseEntity.ok(toDoService.createNewToDo(toDoEntity, userId));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("Can't create a new task.");
        }
    }


    @PutMapping
    public ResponseEntity updateToDo(@RequestParam Long id) {

        try {
            return ResponseEntity.ok(toDoService.updateToDo(id));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("Can't update task.");
        }
    }
}
