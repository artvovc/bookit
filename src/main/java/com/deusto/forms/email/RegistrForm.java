package com.deusto.forms.email;

import com.deusto.models.Registr;

import static java.lang.String.format;

public class RegistrForm implements EmailField {

    private String firstname;
    private String lastname;
    private String url;
    private String email;

    private RegistrForm(Registr registr, String appUrl) {
        this.firstname = registr.getFirstname();
        this.lastname = registr.getLastname();
        this.email = registr.getEmail();
        this.url = format("%s/%s", appUrl, registr.getId());
    }

    public static RegistrForm get(Registr registr, String appUrl) {
        return new RegistrForm(registr, appUrl);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
