package com.deusto.builders;

import com.deusto.models.Address;
import com.deusto.dtos.AddressDTO;

public class AddressBuilder {

    private Address address;

    private AddressBuilder country(String country) {
        this.address.setCountry(country);
        return this;
    }

    private AddressBuilder city(String city) {
        this.address.setCity(city);
        return this;
    }

    private AddressBuilder street(String street) {
        this.address.setStreet(street);
        return this;
    }

    private AddressBuilder postalCode(String postalCode) {
        this.address.setPostalCode(postalCode);
        return this;
    }

    private AddressBuilder houseNumber(int houseNumeber) {
        this.address.setHouseNumber(houseNumeber);
        return this;
    }

    private AddressBuilder apartamentNumber(int apartmentNumber) {
        this.address.setApartamentNumber(apartmentNumber);
        return this;
    }

    public static Address get(AddressDTO addressDTO) {
        Address address = new Address();
        address.setApartamentNumber(addressDTO.getApartamentNumber());
        address.setHouseNumber(addressDTO.getHouseNumber());
        address.setPostalCode(addressDTO.getPostalCode());
        address.setStreet(addressDTO.getStreet());
        address.setCity(addressDTO.getCity());
        address.setCountry(addressDTO.getCountry());
        return address;
    }
}
