package com.deusto.integration.test;


import com.deusto.dtos.RegistrDTO;
import com.deusto.integration.test.common.AbstractIT;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RegisterControllerITest extends AbstractIT {

    @Test
    public void firstStep() throws Exception {
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
    }
}
