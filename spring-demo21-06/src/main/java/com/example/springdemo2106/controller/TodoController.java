package com.example.springdemo2106.controller;

import com.example.springdemo2106.entity.TodoEntity;
import com.example.springdemo2106.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todoEntity,
                                     @RequestParam Long userId){
        try{
            return ResponseEntity.ok(todoService.createTodo(todoEntity, userId));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR");
        }
    }

    @PutMapping
    public ResponseEntity completeTodo(@RequestParam Long id){
        try{
            return ResponseEntity.ok(todoService.completeTodo(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR");
        }
    }
}
