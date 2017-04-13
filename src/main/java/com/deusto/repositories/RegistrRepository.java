package com.deusto.repositories;

import com.deusto.models.Registr;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrRepository extends MongoRepository<Registr, String> {
    Registr findById(String id);

    Registr findByEmail(String email);
}
