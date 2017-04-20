package com.deusto.unit.test.services;

import com.deusto.dtos.LoginDTO;
import com.deusto.security.TokenUtils;
import com.deusto.unit.test.common.AbstractUT;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.springframework.http.HttpStatus.OK;

public class AuthenticationServiceUT extends AbstractUT {

    @Autowired
    private TokenUtils tokenUtils;

    @Test
    @UsingDataSet(locations = "/json/controllers/authentication/actual.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    public void authenticate() {

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("usermail@mail.com");
        loginDTO.setEncryptedPassword("password");

        ResponseEntity response = authenticationService.authentication(loginDTO);

        assertEquals(response.getStatusCode(), OK);
        assertNotNull(response.getBody());

        String token = response.getBody().toString().substring(7, response.getBody().toString().length() - 1);

        assertThat(tokenUtils.getUsernameFromToken(token), is("usermail@mail.com"));

    }


}
