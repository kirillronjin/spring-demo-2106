package com.example.springdemo2106.service;

import com.example.springdemo2106.entity.UserEntity;
import com.example.springdemo2106.exceptions.UserAlreadyExistException;
import com.example.springdemo2106.exceptions.UserNotFoundException;
import com.example.springdemo2106.repository.UserRepo;
import com.example.springdemo2106.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) == null) {
            userRepo.save(user);
            return userRepo.save(user);
        }
        else {
            throw new UserAlreadyExistException("User already exist");
        }
    }

    public User getOne(Long id) throws UserNotFoundException {
        if (userRepo.findById(id).isPresent()) {
            return User.toModel(userRepo.findById(id).get());
        }
        throw new UserNotFoundException("User not found");
    }

    public Long delete(Long id) throws UserNotFoundException {
        if (userRepo.findById(id).isPresent()) {
            userRepo.deleteById(id);
            return id;
        }
        throw new UserNotFoundException("User not found");
    }
}
