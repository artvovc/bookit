package com.deusto.integration.test;

import com.deusto.dtos.ReserveDTO;
import com.deusto.integration.test.common.AbstractIT;
import com.deusto.models.Reserve;
import com.deusto.models.User;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MvcResult;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.hamcrest.Matchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ReserveControllerITest extends AbstractIT {

    Logger logger = Logger.getLogger(ReserveControllerITest.class.getName());

    @Test
    @UsingDataSet(locations = "/json/controllers/reserve/actual.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    @WithUserDetails(value = "usermail@mail.com")
    public void newReserve() throws Exception {
        ReserveDTO reserveDTO = new ReserveDTO();
        reserveDTO.setBookId("58f0aa5e5304b83377b1ac8f");

        /* TODO de modificat cantitatea cartilor - minus 1 */

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(reserveDTO);

        MvcResult result = mvc.perform(post("/reservation/create")
                .contentType(APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user.id", is("51b6eab8cd794eb62bb3e131")))
                .andExpect(jsonPath("$.user.email", is("usermail@mail.com")))
                .andReturn();

        logger.log(Level.INFO, result.getResponse().getContentAsString());
    }

    @Test
    public void getAll() throws Exception {
        mvc.perform(get("/reservation/"))
                .andExpect(status().isOk());
    }

}
