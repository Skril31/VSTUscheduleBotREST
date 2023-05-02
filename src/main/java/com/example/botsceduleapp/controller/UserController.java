package com.example.botsceduleapp.controller;

import com.example.botsceduleapp.model.Schedule.Teacher;
import com.example.botsceduleapp.model.Users.User;
import com.example.botsceduleapp.service.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UsersService usersService;

    @Autowired
    UserController(UsersService usersService){
        this.usersService = usersService;
    }
    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> read(){
        final List<User> users = usersService.readAll();

        return users != null && !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
