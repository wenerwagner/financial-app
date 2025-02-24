package com.wenercastro.projects.financial_app.controller;

import com.wenercastro.projects.financial_app.dto.CreateUser;
import com.wenercastro.projects.financial_app.dto.UpdateUser;
import com.wenercastro.projects.financial_app.dto.UserDTO;
import com.wenercastro.projects.financial_app.model.User;
import com.wenercastro.projects.financial_app.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static com.wenercastro.projects.financial_app.interceptor.AuthInterceptor.LOGGED_USER;
import static com.wenercastro.projects.financial_app.model.Role.ADMIN;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("")
    UserDTO createUser(@RequestBody CreateUser userData) {
        return userService.createUser(userData);
    }

    @GetMapping("")
    List<UserDTO> getUsers(HttpServletRequest request) {
        User user = (User) request.getAttribute(LOGGED_USER);
        if (user != null && !user.getRole().equals(ADMIN)) {
            return userService.findUsers(user.getId());
        }
        return userService.findUsers();
    }

    @GetMapping("/{id}")
    UserDTO getUser(@PathVariable Long id, HttpServletRequest request) throws Exception {
        validateUserId(id, request);
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    UserDTO updateUser(@PathVariable Long id, @RequestBody UpdateUser userData, HttpServletRequest request) throws Exception {
        validateUserId(id, request);
        return userService.updateUser(id, userData);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id, HttpServletRequest request) throws Exception {
        validateUserId(id, request);
        userService.deleteUser(id);
    }

    public static void validateUserId(Long id, HttpServletRequest request) {
        User user = (User) request.getAttribute(LOGGED_USER);
        if (user != null && !user.getRole().equals(ADMIN) && !user.getId().equals(id)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, HttpStatus.FORBIDDEN.getReasonPhrase());
        }
    }
}
