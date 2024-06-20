package com.employee.employee4.controller;

import jakarta.validation.Valid;

import com.employee.employee4.dto.UserDto;
import com.employee.employee4.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // handler method to handle list users request
    @GetMapping({"/users"})
    public String listUsers(Model model){
        List<UserDto> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    // handler method to handle new user request
    @GetMapping("/users/new")
    public String newUser(Model model){
        // user model object to store user form data
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "create_user";
    }

    // handler method to handle save user form submit request
    @PostMapping("/users")
    public String saveUser(@Valid @ModelAttribute("user") UserDto user,
                           BindingResult result,
                           Model model){
        if(result.hasErrors()){
            model.addAttribute("user", user);
            return "create_user";
        }

        userService.createUser(user);
        return "redirect:/users";
    }

    // handler method to handle edit user request
    @GetMapping("/users/{userId}/edit")
    public String editUser(@PathVariable("userId") Long userId,
                           Model model){
        UserDto user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "edit_user";
    }

    // handler method to handle edit user form submit request
    @PostMapping("/users/{userId}")
    public String updateUser(@PathVariable("userId") Long userId,
                             @Valid @ModelAttribute("user") UserDto userDto,
                             BindingResult result,
                             Model model){
        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "edit_user";
        }
        userDto.setId(userId);
        userService.updateUser(userDto);
        return "redirect:/users";
    }

    // Handler method to handle delete user request
    @GetMapping("/users/{userId}/delete")
    public String deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
        return "redirect:/users";
    }

    // Handler method to handle view user request
    @GetMapping("/users/{userId}/view")
    public String viewUser(@PathVariable("userId") Long userId,
                           Model model){
        UserDto userDto = userService.getUserById(userId);
        model.addAttribute("user", userDto);
        return "view_user";
    }
}
