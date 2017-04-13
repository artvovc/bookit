package com.deusto.builders;

import com.deusto.dtos.LoginDTO;
import com.deusto.dtos.PersonDTO;
import com.deusto.models.Registr;
import com.deusto.models.User;

/**
 * Created by diana on 4/12/17.
 */
public class UserBuilder {

    private User user;

    public UserBuilder firstname(String firstName) {
        this.user.setFirstname(firstName);
        return this;
    }

    public UserBuilder lastname(String lastName) {
        this.user.setLastname(lastName);
        return this;
    }

    public UserBuilder email(String email) {
        this.user.setEmail(email);
        return this;
    }

    public UserBuilder birthDate(long birthdate) {
        this.user.setBirthDate(birthdate);
        return this;
    }

    public UserBuilder countryCode(String countryCode) {
        this.user.setCountryCode(countryCode);
        return this;
    }

    public UserBuilder phone(int phone) {
        this.user.setPhone(phone);
        return this;
    }

    public UserBuilder password(String password) {
        this.user.setPassword(password);
        return this;
    }

    public User build() {
        return this.user;
    }

    public static User get(Registr registr) {
        User user = new User();
        user.setFirstname(registr.getFirstname());
        user.setLastname(registr.getLastname());
        user.setEmail(registr.getEmail());
        return user;
    }

    public static User get(Registr registr, PersonDTO person) {
        User user = new User();
        user.setFirstname(registr.getFirstname());
        user.setLastname(registr.getLastname());
        user.setEmail(registr.getEmail());

        user.setPassword(person.getPassword());
        user.setPhone(person.getPhone());
        user.setCountryCode(person.getCountryCode());
        user.setBirthDate(person.getBirthDate());


        //user.setAddress(AddressBuilder.get(person.getAdress()));  TODO implement
        return user;
    }

    public static LoginDTO get(User user) {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail(user.getEmail());
        loginDTO.setEncryptedPassword(user.getPassword());
        return loginDTO;
    }
}
