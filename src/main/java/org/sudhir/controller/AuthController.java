package org.sudhir.controller;

import com.sudhir.stock.model.User;
import com.sudhir.stock.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository repository;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        User newUser = new User();
        newUser.setFullName(user.getFullName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        User savedUser = repository.save(newUser);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);


    }
}
