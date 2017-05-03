package com.deusto.repositories;

import com.deusto.models.Registr;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrRepository extends MongoRepository<Registr, String> {

    Registr findRegistrById(String id);
    Registr findByEmail(String email);
}
