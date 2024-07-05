package com.employee.employee4.controller;


import com.employee.employee4.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;


public class UserController {
    /*

    @GetMapping("/users")
    public List<User> users(){
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("Alwan");

        User user2 = new User();
        user2.setId(2);
        user2.setUsername("Angga");

        User user3 = new User();
        user3.setId(3);
        user3.setUsername("Aisyah");

        users.add(user1);
        users.add(user2);
        users.add(user3);


        return users;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        users().add(user);
        return user;
    }


     */
}
