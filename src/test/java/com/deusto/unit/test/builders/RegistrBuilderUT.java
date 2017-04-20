package com.deusto.unit.test.builders;

import com.deusto.builders.RegistrBuilder;
import com.deusto.dtos.RegistrDTO;
import com.deusto.models.Registr;
import com.deusto.unit.test.common.AbstractUT;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class RegistrBuilderUT extends AbstractUT {

    @Test
    public void validRegistrBuilder() {
        RegistrDTO registrDTO = new RegistrDTO();
        registrDTO.setEmail("email@mail.com");
        registrDTO.setFirstname("Firstname");
        registrDTO.setLastname("Lastname");

        assertTrue(RegistrBuilder.get(registrDTO) != null);
        assertTrue(RegistrBuilder.get(registrDTO) instanceof Registr);

        Registr reg = RegistrBuilder.get(registrDTO);

        assertThat(reg.getEmail(), is("email@mail.com"));
        assertThat(reg.getFirstname(), is("Firstname"));
        assertThat(reg.getLastname(), is("Lastname"));
    }

}
