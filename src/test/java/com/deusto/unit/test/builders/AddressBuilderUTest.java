package com.deusto.unit.test.builders;

import com.deusto.builders.AddressBuilder;
import com.deusto.dtos.AddressDTO;
import com.deusto.models.Address;
import com.deusto.unit.test.common.AbstractUT;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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
}
