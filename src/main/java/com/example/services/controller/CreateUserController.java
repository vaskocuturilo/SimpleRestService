package com.example.services.controller;

import com.example.services.entity.UserEntity;
import com.example.services.exception.UserAlreadyExistException;
import com.example.services.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/create")
public class CreateUserController {

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
}
