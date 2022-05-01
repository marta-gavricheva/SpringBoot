package com.example.springBootdemo2.controller;

import com.example.springBootdemo2.model.User;
import com.example.springBootdemo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String usersALL(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/{id}")
    public String usersId(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "user";
    }

    @GetMapping("/new")
    public String addUser(User user) {
        return "create";
    }

    @PostMapping("/new")
    public String add(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";

    }

    @PostMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
        return "redirect:/";
    }



    @GetMapping("edit/{id}")
    public String updateUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute(userService.findById(id));
        return "edit";
    }


    @PostMapping("/edit")
    public String update( User user) {
   userService.saveUser(user);
            return "redirect:/";
        }
    }
