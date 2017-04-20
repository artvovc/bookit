package com.deusto.unit.test.dtos;

import com.deusto.dtos.RegistrDTO;
import com.deusto.unit.test.common.AbstractUT;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class RegistrDTOUT extends AbstractUT {

    @Test
    public void validRegistrDTO() {
        RegistrDTO registrDTO = new RegistrDTO();

        registrDTO.setFirstname("firstname");
        registrDTO.setLastname("lastname");
        registrDTO.setEmail("some.email@mail.com");

        assertTrue(validate(registrDTO).isEmpty());
    }

    @Test
    public void inValidRegistrDTO() {
        RegistrDTO registrDTO = new RegistrDTO();

        registrDTO.setFirstname("");
        registrDTO.setLastname("");
        registrDTO.setEmail("");

        assertFalse(validate(registrDTO).isEmpty());
        assertThat(validate(registrDTO).size(), is(3));
    }

    @Test
    public void inValidFirstnameEmptyRegistrDTO() {
        RegistrDTO registrDTO = new RegistrDTO();

        registrDTO.setLastname("lastname");
        registrDTO.setEmail("some.email@mail.com");

        assertFalse(validate(registrDTO).isEmpty());
        assertThat(validate(registrDTO).size(), is(1));
    }

    @Test
    public void inValidLastnameEmptyRegistrDTO() {
        RegistrDTO registrDTO = new RegistrDTO();

        registrDTO.setFirstname("firstname");
        registrDTO.setEmail("some.email@mail.com");

        assertFalse(validate(registrDTO).isEmpty());
        assertThat(validate(registrDTO).size(), is(1));
    }

    @Test
    public void inValidFirstnameAndLastnameEmptyRegistrDTO() {
        RegistrDTO registrDTO = new RegistrDTO();

        registrDTO.setEmail("some.email@mail.com");

        assertFalse(validate(registrDTO).isEmpty());
        assertThat(validate(registrDTO).size(), is(2));
    }

    @Test
    public void inValidEmailWrongRegistrDTO() {
        RegistrDTO registrDTO = new RegistrDTO();

        registrDTO.setFirstname("firstname");
        registrDTO.setLastname("lastname");
        registrDTO.setEmail("some.emailmail.com");

        assertFalse(validate(registrDTO).isEmpty());
        assertThat(validate(registrDTO).size(), is(1));
    }

    @Test
    public void inValidEmailEmptyRegistrDTO() {
        RegistrDTO registrDTO = new RegistrDTO();

        registrDTO.setFirstname("firstname");
        registrDTO.setLastname("lastname");

        assertFalse(validate(registrDTO).isEmpty());
        assertThat(validate(registrDTO).size(), is(1));
    }

}
