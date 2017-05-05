package com.deusto.unit.test.dtos;

import com.deusto.dtos.AddressDTO;
import com.deusto.unit.test.common.AbstractUT;
import org.junit.Test;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AddressDTOUTest extends AbstractUT {

    @Test
    public void validBookDTO() {
        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setCountry("Moldova");
        addressDTO.setStreet("Stephan the Great");
        addressDTO.setCity("Chisinau");
        addressDTO.setApartamentNumber(123);
        addressDTO.setHouseNumber(666);
        addressDTO.setPostalCode("4822");

        assertTrue((validate(addressDTO).isEmpty()));

        assertThat(addressDTO.getCity(), is("Chisinau"));
        assertThat(addressDTO.getStreet(), is("Stephan the Great"));
        assertThat(addressDTO.getCountry(), is("Moldova"));
        assertThat(addressDTO.getApartamentNumber(), is(123));
        assertThat(addressDTO.getHouseNumber(), is(666));
        assertThat(addressDTO.getPostalCode(), is("4822"));
    }
}
