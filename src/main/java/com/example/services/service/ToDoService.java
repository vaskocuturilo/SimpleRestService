package com.example.services.service;

import com.example.services.entity.ToDoEntity;
import com.example.services.entity.UserEntity;
import com.example.services.model.ToDo;
import com.example.services.repository.ToDoRepo;
import com.example.services.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepo toDoRepo;

    @Autowired
    UserRepo userRepo;


    public ToDo createNewToDo(ToDoEntity toDoEntity, Long userId) {
        UserEntity userEntity = userRepo.findById(userId).get();
        toDoEntity.setUserEntity(userEntity);

        return ToDo.toModel(toDoRepo.save(toDoEntity));
    }

    public ToDo updateToDo(Long id) {
        ToDoEntity toDoEntity = toDoRepo.findById(id).get();
        toDoEntity.setCompleted(!toDoEntity.getCompleted());

        return ToDo.toModel(toDoRepo.save(toDoEntity));
    }

}

