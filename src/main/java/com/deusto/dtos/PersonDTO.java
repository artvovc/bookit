package com.deusto.dtos;

/**
 * Created by diana on 4/13/17.
 */
public class PersonDTO {
    // uite in altele DTO-uri cum se valideaza
    //TODO trebuie sa fie not empty si validata ca email
    private String email;
    //TODO trebuie sa fie not empty
    private long birthDate;
    //TODO trebuie sa fie not empty
    private String countryCode;
    //TODO trebuie sa fie not empty
    private int phone;
    //TODO trebuie sa fie not empty
    private String password;
    //TODO defineste classa ...
    //TODO adauga builder din DTO -> Entity

    private AddressDTO adress;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AddressDTO getAdress() {
        return adress;
    }

    public void setAdress(AddressDTO adress) {
        this.adress = adress;
    }
}

class AddressDTO {

}