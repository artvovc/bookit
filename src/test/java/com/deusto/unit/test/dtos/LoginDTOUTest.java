package com.deusto.unit.test.dtos;

import com.deusto.dtos.LoginDTO;
import com.deusto.unit.test.common.AbstractUT;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class LoginDTOUTest extends AbstractUT {
    @Test
    public void validLoginDTO() {
        LoginDTO loginDTO = new LoginDTO();

        loginDTO.setEmail("some.email@mail.com");
        loginDTO.setEncryptedPassword("some encrypted password");

        assertTrue(validate(loginDTO).isEmpty());
    }

    @Test
    public void inValidLoginDTO() {
        LoginDTO loginDTO = new LoginDTO();

        loginDTO.setEmail("");
        loginDTO.setEncryptedPassword("");

        assertFalse(validate(loginDTO).isEmpty());
        assertThat(validate(loginDTO).size(), is(2));
    }

    @Test
    public void inValidEmailLoginDTO() {
        LoginDTO loginDTO = new LoginDTO();

        loginDTO.setEmail("some.emailmail.com");
        loginDTO.setEncryptedPassword("some encrypted password");

        assertFalse(validate(loginDTO).isEmpty());
    }

    @Test
    public void inValidEmailEmptyLoginDTO() {
        LoginDTO loginDTO = new LoginDTO();

        loginDTO.setEmail("");
        loginDTO.setEncryptedPassword("some encrypted password");

        assertFalse(validate(loginDTO).isEmpty());
    }

    @Test
    public void inValidPasswordEmptyLoginDTO() {
        LoginDTO loginDTO = new LoginDTO();

        loginDTO.setEmail("some.email@mail.com");
        loginDTO.setEncryptedPassword("");

        assertFalse(validate(loginDTO).isEmpty());
    }

}
