package com.example.services.model;

import com.example.services.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class User {

    private Long id;
    private String username;
    private List<ToDo> toDoList;

    public static User toModel(UserEntity userEntity) {
        User userModel = new User();
        userModel.setId(userEntity.getId());
        userModel.setUsername(userEntity.getUsername());
        userModel.setToDoList(userEntity.getToDoEntityList().stream().map(ToDo::toModel).collect(Collectors.toList()));

        return userModel;
    }

    public User() {
    }

    public List<ToDo> getToDoList() {
        return toDoList;
    }

    public void setToDoList(List<ToDo> toDoList) {
        this.toDoList = toDoList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
