package com.example.botsceduleapp.controller;

import com.example.botsceduleapp.model.tg_users_an;
import com.example.botsceduleapp.model.Users.User;
import com.example.botsceduleapp.service.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> read(@PathVariable(name = "id") int id){
        final User user = usersService.read(id);

        return user != null
                ? new ResponseEntity<>(user,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping(value = "/users")
    public ResponseEntity<?> create(@RequestBody User user){
        usersService.create(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<?> update(@RequestBody User user,@PathVariable(name = "id") int id){
        final boolean updated = usersService.update(user,id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id){
        final boolean deleted = usersService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/users/{group}/list")
    public ResponseEntity<List<tg_users_an>> GroupFilter(@PathVariable(name = "group") String group){
        List<tg_users_an> list= usersService.GetByGroup(group);

        return list != null && !list.isEmpty()
                ? new ResponseEntity<>(list,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
