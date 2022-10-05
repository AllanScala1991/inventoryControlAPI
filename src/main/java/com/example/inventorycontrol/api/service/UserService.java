package com.example.inventorycontrol.api.service;

import com.example.inventorycontrol.api.model.UserModel;
import com.example.inventorycontrol.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Transactional
    public UserModel createUser(UserModel userModel) {
        return userRepository.save(userModel);
    }

    public List<UserModel> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserModel> findUserById(UUID id) {
        return userRepository.findById(id);
    }

    public Optional<UserModel> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean existsByMail(String mail) {
        return userRepository.existsByMail(mail);
    }

    public boolean existsById(UUID id) { return userRepository.existsById(id); }
}
