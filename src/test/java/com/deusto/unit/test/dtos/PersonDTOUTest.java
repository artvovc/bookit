package com.deusto.unit.test.dtos;

import com.deusto.dtos.AddressDTO;
import com.deusto.dtos.PersonDTO;
import com.deusto.unit.test.common.AbstractUT;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PersonDTOUTest extends AbstractUT {

    @Test
    public void validPersonDTO() {
        PersonDTO personDTO = new PersonDTO();

        personDTO.setBirthDate(0);

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCountry("Moldova");
        personDTO.setAddress(addressDTO);

        personDTO.setEmail("email@example.com");
        personDTO.setCountryCode("1234");
        personDTO.setPassword("password");
        personDTO.setPhone(123456789);

        assertTrue(validate(personDTO).isEmpty());
        assertThat(personDTO.getAddress().getCountry(), is("Moldova"));
        assertThat(personDTO.getEmail(), is("email@example.com"));
        assertThat(personDTO.getCountryCode(), is("1234"));
        assertThat(personDTO.getPassword(), is("password"));
        assertThat(personDTO.getPhone(), is(123456789));
    }

    @Test
    public void invalidEmailPeronDTO() {

        PersonDTO personDTO = new PersonDTO();
        personDTO.setEmail("email.example.com");

        assertFalse(validate(personDTO).isEmpty());
    }

    @Test
    public void invalidEmptyEmailPersontDTO() {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setEmail("");

        assertFalse(validate(personDTO).isEmpty());
    }

    @Test
    public void invalidEmptyCountryCodePersonDTO() {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setCountryCode("");

        assertFalse(validate(personDTO).isEmpty());
    }

    @Test
    public void invalidEmptyPasswordPersonDTO() {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setPassword("");

        assertFalse(validate(personDTO).isEmpty());
    }
}
