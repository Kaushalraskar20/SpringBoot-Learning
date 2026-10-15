package com.xpert;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String listUsers(Model model) {
        List<User> users = service.listUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id, Model model) {
        User user = service.getUser(id).orElse(null);
        model.addAttribute("user", user);
        model.addAttribute("users", service.listUsers());
        return "users";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam Long userid,
                             @RequestParam String name,
                             @RequestParam String email) {

        service.updateUser(userid, name, email);

        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam Long userid) {

        service.deleteUser(userid);

        return "redirect:/users";
    }
}