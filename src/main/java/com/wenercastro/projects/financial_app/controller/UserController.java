package com.wenercastro.projects.financial_app.controller;

import com.wenercastro.projects.financial_app.annotations.RequireAuth;
import com.wenercastro.projects.financial_app.dto.CreateUser;
import com.wenercastro.projects.financial_app.dto.UpdateUser;
import com.wenercastro.projects.financial_app.dto.UserDTO;
import com.wenercastro.projects.financial_app.model.Role;
import com.wenercastro.projects.financial_app.model.User;
import com.wenercastro.projects.financial_app.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static com.wenercastro.projects.financial_app.model.Role.ADMIN;
import static com.wenercastro.projects.financial_app.model.Role.USER;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@RequestBody CreateUser userData) {
        userService.createUser(userData);
    }

    @RequireAuth({ADMIN, USER})
    @GetMapping("")
    List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @RequireAuth
    @GetMapping("/{id}")
    UserDTO getUser(@PathVariable Long id, HttpServletRequest request) throws Exception {
        Role role = Role.valueOf((String) request.getAttribute("loggedUserRole"));
        String email = (String) request.getAttribute("loggedUserEmail");

        User user = userService.getUserByEmail(email);
        if (!role.equals(ADMIN) && !user.getId().equals(id)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Acesso negado");
        }

        return userService.getUserById(id);
    }

    @RequireAuth({ADMIN, USER})
    @PutMapping("/{id}")
    UserDTO updateUser(@PathVariable Long id, @RequestBody UpdateUser userData, HttpServletRequest request) throws Exception {
        Role role = Role.valueOf((String) request.getAttribute("loggedUserRole"));
        String email = (String) request.getAttribute("loggedUserEmail");

        User user = userService.getUserByEmail(email);
        if (!role.equals(ADMIN) && !user.getId().equals(id)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Acesso negado");
        }
        return userService.updateUser(id, userData);
    }

    @RequireAuth({ADMIN, USER})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id, HttpServletRequest request) throws Exception {
        Role role = Role.valueOf((String) request.getAttribute("loggedUserRole"));
        String email = (String) request.getAttribute("loggedUserEmail");

        User user = userService.getUserByEmail(email);
        if (!role.equals(ADMIN) && !user.getId().equals(id)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Acesso negado");
        }
        userService.deleteUser(id);
    }
}
