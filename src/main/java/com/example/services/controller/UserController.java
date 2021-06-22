package com.example.services.controller;

import com.example.services.entity.UserEntity;
import com.example.services.exception.UserAlreadyExistException;
import com.example.services.exception.UserNotFoundException;
import com.example.services.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserEntity userEntity) {
        try {
            userService.createUser(userEntity);
            return ResponseEntity.ok("A new user was created.");
        } catch (UserAlreadyExistException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("Can't create new user.");
        }
    }

    @GetMapping
    public ResponseEntity getUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getUser(id));
        } catch (UserNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("The user with id  = " + id + " was not found.");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity removeUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok("The user with id " + userService.deleteUser(id) + " was deleted.");
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("Unable to delete user.");
        }
    }
}
