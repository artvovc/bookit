package com.deusto.dtos;

public class AddressDTO {

    private String country;
    private String city;
    private String street;
    private String postalCode;
    private Integer houseNumber;
    private Integer apartamentNumber;

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Integer getApartamentNumber() {
        return apartamentNumber;
    }

    public void setApartamentNumber(Integer apartamentNumber) {
        this.apartamentNumber = apartamentNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}