package com.example.springdemo2106.controller;

import com.example.springdemo2106.entity.UserEntity;
import com.example.springdemo2106.exceptions.UserAlreadyExistException;
import com.example.springdemo2106.exceptions.UserNotFoundException;
import com.example.springdemo2106.repository.UserRepo;
import com.example.springdemo2106.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) throws UserAlreadyExistException {
        try{
            userService.registration(user);
            return ResponseEntity.ok("SUCCESS");
        }
        catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("ERROR");
        }
    }

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id){
        try{
            return ResponseEntity.ok(userService.getOne(id));
        }
        catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try{
            return ResponseEntity.ok(userService.delete(id));
        }
        catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR");
        }
    }

}
