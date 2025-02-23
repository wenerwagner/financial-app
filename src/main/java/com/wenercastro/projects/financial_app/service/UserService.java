package com.wenercastro.projects.financial_app.service;

import com.wenercastro.projects.financial_app.dto.CreateUser;
import com.wenercastro.projects.financial_app.dto.UpdateUser;
import com.wenercastro.projects.financial_app.dto.UserDTO;
import com.wenercastro.projects.financial_app.model.User;
import com.wenercastro.projects.financial_app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public void createUser(CreateUser userData) {
        User user = User.builder()
                .email(userData.email())
                .name(userData.name())
                .password(userData.password())
                .build();
        userRepository.save(user);
    }

    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> new UserDTO(user.getId(), user.getName(), user.getEmail())).toList();
    }

    public UserDTO getUserById(Long id) throws Exception {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new Exception("User not found");
        }
        User user = optionalUser.get();
        return new UserDTO(user.getId(), user.getName(), user.getEmail());
    }

    public UserDTO updateUser(Long id, UpdateUser userData) throws Exception {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new Exception("User not found");
        }
        User user = optionalUser.get();
        user.setEmail(userData.email());
        user.setName(userData.name());
        user.setPassword(userData.password());
        user = userRepository.save(user);
        return new UserDTO(user.getId(), user.getName(), user.getEmail());
    }

    public void deleteUser(Long id) throws Exception{
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new Exception("User not found");
        }
        User user = optionalUser.get();
        userRepository.delete(user);
    }
}
