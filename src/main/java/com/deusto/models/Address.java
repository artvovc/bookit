package com.deusto.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "addresses")
public class Address {
	@Id
	private String id;
	private String street;
    private Integer houseNumber;
    private Integer apartamentNumber;
    private String postalCode;
	private String city;
	private String country;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}

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
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
