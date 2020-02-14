package com.arnasrad.vismainternship.model.revolut.requestbody;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CounterpartyRequestBody {

    @JsonProperty("profile_type")
    private String profileType;
    private String name;
    private String phone;
    private String email;

    public CounterpartyRequestBody() {
    }

    public CounterpartyRequestBody(String profileType, String name, String phone, String email) {
        this.profileType = profileType;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getProfileType() {
        return profileType;
    }

    public void setProfileType(String profileType) {
        this.profileType = profileType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
