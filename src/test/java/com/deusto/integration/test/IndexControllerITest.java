package com.deusto.integration.test;

import com.deusto.integration.test.common.AbstractIT;
import com.lordofthejars.nosqlunit.annotation.ShouldMatchDataSet;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/***
 * more info HAMCREST -> http://www.vogella.com/tutorials/Hamcrest/article.html
 *           JSONPATH -> https://www.petrikainulainen.net/programming/spring-framework/integration-testing-of-spring-mvc-applications-write-clean-assertions-with-jsonpath/
 */
public class IndexControllerITest extends AbstractIT {

    @Test
    @UsingDataSet(locations = "/json/controllers/index/actual.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    @ShouldMatchDataSet(location = "/json/controllers/index/expect.json")
    public void unauth() throws Exception {
        System.out.println(env.getProperty("spring.data.mongodb.database"));

        MvcResult result = mvc.perform(get("/index/unauth"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn();

        assertNotNull(result.getResponse());
        assertThat(5, is(5));
        System.out.println((result.getResponse()));

    }

    @Test
    @UsingDataSet(locations = "/json/controllers/index/actual.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    @ShouldMatchDataSet(location = "/json/controllers/index/expect.json")
    @WithMockUser
    public void auth() throws Exception {
        MvcResult result = mvc.perform(get("/index/auth"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.ageLimit", is(18)))
                .andExpect(jsonPath("$.count", is(3)))
                .andReturn();

        System.out.println((result.getResponse().getContentAsString()));

    }

    @Test
    public void authCrash() throws Exception {
        mvc.perform(get("/index/auth"))
                .andExpect(status().isUnauthorized());
    }
}
