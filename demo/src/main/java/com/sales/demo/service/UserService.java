package com.sales.demo.service;

import com.sales.demo.model.User;
import com.sales.demo.repository.UserRepository;

import java.util.List;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User create(User user) {
        String hashPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public void deletUser(Long id) {
        Optional<User> user = userRepository.findById(id);

        User existingUser = user.orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        userRepository.deleteById(existingUser.getId());
    }
}
