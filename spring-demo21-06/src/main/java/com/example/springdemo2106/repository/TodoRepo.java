package com.example.springdemo2106.repository;

import com.example.springdemo2106.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {

}
