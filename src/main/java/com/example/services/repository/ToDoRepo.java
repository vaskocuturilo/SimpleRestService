package com.example.services.repository;

import com.example.services.entity.ToDoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepo extends CrudRepository<ToDoEntity, Long> {
}
