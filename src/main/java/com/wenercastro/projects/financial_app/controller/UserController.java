package com.wenercastro.projects.financial_app.controller;

import com.wenercastro.projects.financial_app.annotations.RequireAuth;
import com.wenercastro.projects.financial_app.dto.CreateUser;
import com.wenercastro.projects.financial_app.dto.UpdateUser;
import com.wenercastro.projects.financial_app.dto.UserDTO;
import com.wenercastro.projects.financial_app.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.wenercastro.projects.financial_app.model.Role.ADMIN;
import static com.wenercastro.projects.financial_app.model.Role.USER;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @RequireAuth(ADMIN)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@RequestBody CreateUser userData) {
        userService.createUser(userData);
    }

    @RequireAuth(ADMIN)
    @GetMapping("")
    List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @RequireAuth(USER)
    @GetMapping("/{id}")
    UserDTO getUser(@PathVariable Long id) throws Exception {
        return userService.getUserById(id);
    }

    @RequireAuth(USER)
    @PutMapping("/{id}")
    UserDTO updateUser(@PathVariable Long id, @RequestBody UpdateUser userData) throws Exception {
        return userService.updateUser(id, userData);
    }

    @RequireAuth(ADMIN)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id) throws Exception {
        userService.deleteUser(id);
    }
}
