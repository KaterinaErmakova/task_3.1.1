package org.example.springbootapp.controller;

import org.example.springbootapp.models.User;
import org.example.springbootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showAllUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/add_user")
    public String showAddUserForm() {
        return "addUser";
    }

    @PostMapping("/save_user")
    public String saveUser(@RequestBody User user) {

        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit_user")
    public String showEditUserForm(@RequestParam("id") int id, ModelMap model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/update_user")
    public String updateUser(@RequestParam("id") int id,
                             @RequestBody User user) {
        userService.updateUser(id, user);
        return "redirect:/";
    }

    @PostMapping("/delete_user")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
