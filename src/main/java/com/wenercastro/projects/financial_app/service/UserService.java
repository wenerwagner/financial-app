package com.wenercastro.projects.financial_app.service;

import com.wenercastro.projects.financial_app.dto.CreateUser;
import com.wenercastro.projects.financial_app.dto.UpdateUser;
import com.wenercastro.projects.financial_app.dto.UserDTO;
import com.wenercastro.projects.financial_app.exception.UserNotFoundException;
import com.wenercastro.projects.financial_app.model.Role;
import com.wenercastro.projects.financial_app.model.User;
import com.wenercastro.projects.financial_app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public UserDTO createUser(CreateUser userData) {
        User user = User.builder()
                .email(userData.email())
                .name(userData.name())
                .password(userData.password())
                .role(Role.USER)
                .build();
        user = userRepository.save(user);
        return new UserDTO(user.getId(), user.getName(), user.getEmail());
    }

    public List<UserDTO> findUsers() {
        List<User> users = new ArrayList<>((Collection) userRepository.findAll());
        return users.stream().map(user -> new UserDTO(user.getId(), user.getName(), user.getEmail())).toList();
    }

    public List<UserDTO> findUsers(Long id) {
        List<User> users = new ArrayList<>((Collection) userRepository.findAllById(Collections.singleton(id)));
        return users.stream().map(user -> new UserDTO(user.getId(), user.getName(), user.getEmail())).toList();
    }

    public UserDTO getUser(Long id) throws Exception {
        User user = validateAndGetUser(userRepository.findById(id));
        return new UserDTO(user.getId(), user.getName(), user.getEmail());
    }

    public UserDTO updateUser(Long id, UpdateUser userData) throws Exception {
        User user = validateAndGetUser(userRepository.findById(id));
        user.setEmail(userData.email());
        user.setName(userData.name());
        user.setPassword(userData.password());
        user = userRepository.save(user);
        return new UserDTO(user.getId(), user.getName(), user.getEmail());
    }

    public void deleteUser(Long id) throws Exception{
        User user = validateAndGetUser(userRepository.findById(id));
        userRepository.delete(user);
    }

    public User getUserByEmail(String email) throws Exception{
        return validateAndGetUser(userRepository.findByEmail(email));
    }

    private static User validateAndGetUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }
        return optionalUser.get();
    }

}
