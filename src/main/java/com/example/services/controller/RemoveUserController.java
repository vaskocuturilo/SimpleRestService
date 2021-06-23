package com.example.services.controller;

import com.example.services.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/remove")
public class RemoveUserController {
    @Autowired
    private UserService userService;
    @DeleteMapping("{id}")
    public ResponseEntity removeUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok("The user with id = " + userService.deleteUser(id) + " was deleted.");
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("Unable to delete user.");
        }
    }
}
