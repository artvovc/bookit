package com.deusto.dtos;

import org.apache.commons.validator.routines.EmailValidator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class LoginDTO {
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String encryptedPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = EmailValidator.getInstance().isValid(email) ? email : "";
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

}
