package com.deusto.services;

import com.deusto.models.Registr;
import com.deusto.models.User;
import com.deusto.repositories.RegistrRepository;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Update.update;

@Service
public class RegistrService {

    @Autowired
    private RegistrRepository registrRepository;

    @Autowired
    private MongoOperations operations;

    public Registr insert(Registr reg) {
        return registrRepository.insert(reg);
    }

    public Registr findById(String id) {
        return registrRepository.findRegistrById(id);
    }

    public Map<?, ?> updateReg(String id) {
        operations.findAndModify(new Query(where("_id").is(id)), update("isActiv", true), Registr.class);
        return ImmutableMap.of("message", "successful activated");
    }

    public Optional<Registr> findByEmail(String email) {
        return Optional.ofNullable(operations.findOne(new Query(where("email").is(email)), Registr.class));
    }

    public void delete(Registr registr) {
        registrRepository.delete(registr);
    }

    public boolean exists(String email) {
        return operations.exists(new Query(where("email").is(email)), Registr.class)
                || operations.exists(new Query(where("email").is(email)), User.class);
    }
}
