package com.deusto.unit.test.builders;

import com.deusto.builders.AddressBuilder;
import com.deusto.dtos.AddressDTO;
import com.deusto.models.Address;
import com.deusto.unit.test.common.AbstractUT;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AddressBuilderUTest extends AbstractUT {

    @Test
    public void validAdderessBuilder() {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setApartamentNumber(123);
        addressDTO.setCity("Chisinau");
        addressDTO.setCountry("Moldova");
        addressDTO.setStreet("Stefan The Great");

        assertTrue(AddressBuilder.get(addressDTO) != null);
        assertTrue(AddressBuilder.get(addressDTO) instanceof Address);

        Address address = AddressBuilder.get(addressDTO);
        assertThat(address.getApartamentNumber(), is(123));
        assertThat(address.getCity(), is("Chisinau"));;
        assertThat(address.getCountry(), is("Moldova"));
        assertThat(address.getStreet(), is("Stefan The Great"));
    }

    @Test
    public void validAdderessBuilderMethodStyle() {
        Address address = AddressBuilder
                .builder()
                .apartamentNumber(1)
                .city("Chisinau")
                .country("Moldova")
                .houseNumber(23)
                .postalCode("MD-2421")
                .street("armeneasca")
                .build();

        assertThat(address.getApartamentNumber(), is(1));
        assertThat(address.getCity(), is("Chisinau"));
        assertThat(address.getCountry(), is("Moldova"));
        assertThat(address.getHouseNumber(), is(23));
        assertThat(address.getPostalCode(), is("MD-2421"));
        assertThat(address.getStreet(), is("armeneasca"));

        address = AddressBuilder
                .builder()
                .apartamentNumber(2)
                .build();

        assertThat(address.getApartamentNumber(), is(2));
        assertNull(address.getCity());
        assertNull(address.getCountry());
        assertNull(address.getHouseNumber());
        assertNull(address.getPostalCode());
        assertNull(address.getStreet());
    }
}
