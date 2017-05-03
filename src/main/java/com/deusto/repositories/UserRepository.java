package com.deusto.repositories;

import com.deusto.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findUserById(String id);
    User findByEmail(String email);
    List<User> findAllByFirstname(String firstName);
    List<User> findAllByLastname(String lastName);
    User findByPhone(Long phone);
    void delete(User user);
}

