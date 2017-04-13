package com.deusto.services;

import com.deusto.models.Registr;
import com.deusto.repositories.RegistrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrService {

    @Autowired
    private RegistrRepository registrRepository;

    public Registr insert(Registr reg) {
        return registrRepository.insert(reg);
    }

    public Registr findById(String id) {
        return registrRepository.findById(id);
    }

    public void update(Registr registr) {
        registrRepository.save(registr);
    }

    public Registr findByEmail(String email) {
        return registrRepository.findByEmail(email);
    }

    public void delete(Registr registr) {
        registrRepository.delete(registr);
    }
}
