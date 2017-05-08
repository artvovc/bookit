package com.deusto.unit.test.builders;

import com.deusto.builders.RegistrBuilder;
import com.deusto.builders.UserBuilder;
import com.deusto.dtos.AddressDTO;
import com.deusto.dtos.PersonDTO;
import com.deusto.dtos.RegistrDTO;
import com.deusto.models.Registr;
import com.deusto.models.User;
import com.deusto.unit.test.common.AbstractUT;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class UserBuilderUTest extends AbstractUT {

    @Test
    public void validUserBuilder() {
        RegistrDTO registrDTO = new RegistrDTO();
        registrDTO.setEmail("bookit1617@gmail.com");
        registrDTO.setFirstname("FirstName");
        registrDTO.setLastname("LastName");

        Registr registr = RegistrBuilder.get(registrDTO);

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCountry("Moldova");

        PersonDTO personDTO = new PersonDTO();
        personDTO.setAddress(addressDTO);

        assertTrue(UserBuilder.get(registr, personDTO) != null);
        assertTrue(UserBuilder.get(registr, personDTO) instanceof User);

        User user = UserBuilder.get(registr, personDTO);
        assertThat(user.getEmail(), is("bookit1617@gmail.com"));
        assertThat(user.getFirstname(), is("FirstName"));
        assertThat(user.getLastname(), is("LastName"));
        assertThat(user.getAddress().getCountry(), is("Moldova"));
    }

    @Test
    public void validUserBuilderMethodStyle() {
        User user = UserBuilder
                .builder()
                .email("email@mail.asdaqwe")
                .firstname("firstname")
                .lastname("lastname")
                .password("asd")
                .phone(123)
                .countryCode("MD")
                .birthDate(12L)
                .build();

        assertThat(user.getEmail(), is("email@mail.asdaqwe"));
        assertThat(user.getFirstname(), is("firstname"));
        assertThat(user.getLastname(), is("lastname"));
        assertThat(user.getPassword(), is("asd"));
        assertThat(user.getPhone(), is(123));
        assertThat(user.getCountryCode(), is("MD"));
        assertThat(user.getBirthDate(), is(12L));

        user = UserBuilder
                .builder()
                .password("asd1")
                .birthDate(121L)
                .build();

        assertNull(user.getEmail());
        assertNull(user.getFirstname());
        assertNull(user.getLastname());
        assertThat(user.getPassword(), is("asd1"));
        assertNull(user.getPhone());
        assertNull(user.getCountryCode());
        assertThat(user.getBirthDate(), is(121L));

    }

}
