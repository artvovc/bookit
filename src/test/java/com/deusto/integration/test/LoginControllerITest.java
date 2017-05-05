package com.deusto.integration.test;

import com.deusto.dtos.LoginDTO;
import com.deusto.integration.test.common.AbstractIT;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class LoginControllerITest extends AbstractIT {

    Logger logger = Logger.getLogger(LoginControllerITest.class.getName());

    @Test
    @UsingDataSet(locations = "/json/controllers/login/actual.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    public void login() throws Exception {

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEncryptedPassword("password");
        loginDTO.setEmail("usermail@mail.com");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(loginDTO);

        MvcResult mvcResult = mvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andReturn();

        logger.log(Level.WARNING, mvcResult.getResponse().getContentAsString());
    }

    @Test
    @UsingDataSet(locations = "/json/controllers/login/actual.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    public void loginWrongCredentials() throws Exception {

        LoginDTO loginDTO = new LoginDTO();

        loginDTO.setEmail("wrongemail@gmail.com");
        loginDTO.setEncryptedPassword("random passwd");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(loginDTO);

        MvcResult mvcResult = mvc.perform(post("login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isUnauthorized())
                .andReturn();
        
        logger.log(Level.WARNING, mvcResult.getResponse().getContentAsString());
    }
}
