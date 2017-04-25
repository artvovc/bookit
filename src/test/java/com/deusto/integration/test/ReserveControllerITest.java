package com.deusto.integration.test;

import com.deusto.dtos.ReserveDTO;
import com.deusto.integration.test.common.AbstractIT;
import com.deusto.models.Reserve;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ReserveControllerITest extends AbstractIT {

    @Test
//    @UsingDataSet(locations = "/json/controllers/reserve/actual.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    @WithMockUser
    public void newReserve() throws Exception {
        ReserveDTO reserveDTO = new ReserveDTO();
        reserveDTO.setBookId("58fe0fd55304b8358563f10b");

        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(reserveDTO);

        MvcResult result = mvc.perform(post("/reservation/create")
                .contentType(APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andReturn();

//        System.out.println((result.getResponse().getContentAsString()));
    }

    @Test
    public void getAll() throws Exception {
        mvc.perform(get("/reservation/"))
                .andExpect(status().isOk());
    }

}
