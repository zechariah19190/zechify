package com.zechify.zechify.controller;


import com.zechify.zechify.entity.User;
import com.zechify.zechify.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UserController {

    private final UserRepository userRepository;


    @RequestMapping
    @CacheEvict(allEntries = true)
    public ResponseEntity<User> addUser(@RequestBody User user){
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }



    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
