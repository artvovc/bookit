package com.deusto.builders;

import com.deusto.dtos.AddressDTO;
import com.deusto.models.Address;

public class AddressBuilder {

    private Address address = new Address();

    private AddressBuilder() {
    }

    public AddressBuilder country(String country) {
        this.address.setCountry(country);
        return this;
    }

    public AddressBuilder city(String city) {
        this.address.setCity(city);
        return this;
    }

    public AddressBuilder street(String street) {
        this.address.setStreet(street);
        return this;
    }

    public AddressBuilder postalCode(String postalCode) {
        this.address.setPostalCode(postalCode);
        return this;
    }

    public AddressBuilder houseNumber(Integer houseNumeber) {
        this.address.setHouseNumber(houseNumeber);
        return this;
    }

    public AddressBuilder apartamentNumber(Integer apartmentNumber) {
        this.address.setApartamentNumber(apartmentNumber);
        return this;
    }

    public static AddressBuilder builder() {
        return new AddressBuilder();
    }

    public Address build() {
        return this.address;
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
