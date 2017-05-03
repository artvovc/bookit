package com.deusto.integration.test;

import com.deusto.integration.test.common.AbstractIT;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MvcResult;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class BookControllerITest extends AbstractIT {

    Logger logger = Logger.getLogger(ReserveControllerITest.class.getName());

    @Test
    @UsingDataSet(locations = "/json/controllers/book/actual.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    @WithUserDetails(value = "usermail@mail.com")
    public void getAllBooksFilter() throws Exception {
        String title = "Luceafarul";

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(title);

        MvcResult result = mvc.perform(get("/book/filter")
                .contentType(APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andReturn();

        logger.log(Level.WARNING, result.getResponse().getContentAsString());
    }

//    @Test
//    @UsingDataSet(locations = "/json/controllers/book/actual.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
//    @WithUserDetails(value = "usermail@mail.com")
//    public void findAll() throws Exception {
//        MvcResult result = mvc.perform(get("/book"))
//                .andExpect(status().isOk())
//                .andReturn();
//    }
}
