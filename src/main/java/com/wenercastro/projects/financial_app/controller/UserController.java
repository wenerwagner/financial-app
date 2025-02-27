package com.wenercastro.projects.financial_app.controller;

import com.wenercastro.projects.financial_app.model.Role;
import com.wenercastro.projects.financial_app.model.User;
import com.wenercastro.projects.financial_app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/admin/users")
@AllArgsConstructor
public class UserController {

    private UserRepository userRepository;

    @PostMapping("")
    User createUser(@RequestBody User user) {
        user.setId(null);
        user.setRole(Role.USER);
        return userRepository.save(user);
    }

    @GetMapping("")
    List<User> getUsers() {
        return new ArrayList<>((Collection) userRepository.findAll());
    }

    @GetMapping("/{id}")
    User getUser(@PathVariable Long id) {
        return userRepository.findById(id).get();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
