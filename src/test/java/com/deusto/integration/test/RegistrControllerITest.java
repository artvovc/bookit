package com.deusto.integration.test;


import com.deusto.dtos.RegistrDTO;
import com.deusto.integration.test.common.AbstractIT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RegistrControllerITest extends AbstractIT {
    @Test
    public void ValidPostRegistr() throws Exception {

        RegistrDTO registrDTO = new RegistrDTO();

        registrDTO.setFirstname("firstname");
        registrDTO.setLastname("lastname");
        registrDTO.setEmail("some.email@mail.com");

        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(registrDTO);

        MvcResult result = mvc.perform(post("/registration")
                .contentType(APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andReturn();

        System.out.println((result.getResponse().getContentAsString()));
    }
}
