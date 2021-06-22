package com.example.services.service;

import com.example.services.entity.UserEntity;
import com.example.services.exception.UserAlreadyExistException;
import com.example.services.exception.UserNotFoundException;
import com.example.services.model.User;
import com.example.services.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public UserEntity createUser(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("The user with name " + user.getUsername() + " was created earlier.");
        }
        return userRepo.save(user);
    }

    public User getUser(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("User with id = " + id + " was not found.");
        }
        return User.toModel(user);
    }

    public Long deleteUser(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
