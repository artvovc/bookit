package com.deusto.services;

import com.deusto.models.User;
import com.deusto.repositories.AddressRepository;
import com.deusto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    public User insert(User user) {
        user.setAddress(addressRepository.insert(user.getAddress()));
        return userRepository.insert(user);
    }

    public User findById(String id) {
        return userRepository.findById(id);
    }
}
