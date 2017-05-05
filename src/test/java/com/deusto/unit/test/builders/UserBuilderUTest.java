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

}
