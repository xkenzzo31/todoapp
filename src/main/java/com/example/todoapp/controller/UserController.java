package com.example.todoapp.controller;

import com.example.todoapp.entity.User;
import com.example.todoapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Controller + ResponseBody
@RequestMapping ("/api/v1/user")
public class UserController {

    private UserService userService;
    private String toto;
    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("")
    public List<User> getUsers() {
        return this.userService.getUsers();
    }

    @RequestMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        toto = "bonjour" +id;
        return this.userService.findUsersById(id);
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<User> postProject(@RequestBody User user) {
        System.out.println(user.getEMAIL());

        return new ResponseEntity<User>(this.userService.createUser(user), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(User user) {
        return ResponseEntity.ok(this.userService.updateUser(user));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteUser(Long id) {
        this.userService.deleteUser(id);
    }


}
