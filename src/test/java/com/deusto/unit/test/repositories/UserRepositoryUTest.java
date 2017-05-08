package com.deusto.unit.test.repositories;

import com.deusto.models.User;
import com.deusto.unit.test.common.AbstractUT;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class UserRepositoryUTest extends AbstractUT {

    @Test
    @UsingDataSet(locations = "/json/repositories/user/actual.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    public void findUserByIdTest() throws Exception{
        assertTrue(userRepository.findUserById("51b6eab8cd794eb62bb3e131") instanceof User);
        assertThat(userRepository.findUserById("51b6eab8cd794eb62bb3e131").getId(), is("51b6eab8cd794eb62bb3e131"));
    }

    @Test
    @UsingDataSet(locations = "/json/repositories/user/actual.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    public void findByEmailTest() throws Exception {
        assertTrue(userRepository.findByEmail("usermail@mail.com") instanceof User);
        assertThat(userRepository.findByEmail("usermail@mail.com").getId(), is("51b6eab8cd794eb62bb3e131"));
    }

    @Test
    @UsingDataSet(locations = "/json/repositories/user/actual.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    public void findAllByFirstnameTest() throws Exception {
        assertNotNull(userRepository.findAllByFirstname("firstname2"));
        assertThat(userRepository.findAllByFirstname("firstname2").get(0).getFirstname(), is("firstname2"));
    }

    @Test
    @UsingDataSet(locations = "/json/repositories/user/actual.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    public void findAllByLastnameTest() throws Exception {
        assertNotNull(userRepository.findAllByLastname("lastname2"));
        assertThat(userRepository.findAllByLastname("lastname2").get(0).getLastname(), is("lastname2"));
    }

    /* solve int - long problem */
    /*
    @Test
    @UsingDataSet(locations = "/json/repositories/user/actual.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    public void findByPhoneTest() throws Exception {
        assertNotNull(userRepository.findByPhone(69159159L));
        assertTrue(userRepository.findByPhone(69159159L) instanceof User);
        assertThat(userRepository.findByPhone(69159159L).getPhone(), is(69159159L));
    }
    */
}
