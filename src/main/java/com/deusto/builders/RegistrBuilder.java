package com.deusto.builders;

import com.deusto.dtos.RegistrDTO;
import com.deusto.models.Registr;

public class RegistrBuilder {
    public static Registr get(RegistrDTO registrDTO) {
        Registr registr = new Registr();
        registr.setEmail(registrDTO.getEmail());
        registr.setFirstname(registrDTO.getFirstname());
        registr.setLastname(registrDTO.getLastname());
        return registr;
    }
}
