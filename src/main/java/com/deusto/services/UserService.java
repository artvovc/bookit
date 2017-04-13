package com.deusto.services;

import com.deusto.models.User;
import com.deusto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User insert(User user) {
        return userRepository.insert(user);
    }

    public User findById(String id) {
        return userRepository.findById(id);
    }
}
