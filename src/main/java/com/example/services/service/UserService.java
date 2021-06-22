package com.example.services.service;

import com.example.services.entity.UserEntity;
import com.example.services.exception.UserAlreadyExistException;
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
}
