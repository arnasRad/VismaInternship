package com.arnasrad.vismainternship.revolut.model.counterparty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Counterparty {

    private String id;
    private String name;
    private String phone;
    @JsonProperty("profile_type")
    private String profileType;
    @JsonProperty("country")
    private String country;
    private String state;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("updated_at")
    private Date updatedAt;
    private CounterpartyAccount[] accounts;

    public Counterparty() {
    }

    public Counterparty(String id, String name, String phone, String profileType, String country, String state, Date createdAt, Date updatedAt, CounterpartyAccount[] accounts) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.profileType = profileType;
        this.country = country;
        this.state = state;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.accounts = accounts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getProfileType() {
        return profileType;
    }

    public void setProfileType(String profileType) {
        this.profileType = profileType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public CounterpartyAccount[] getAccounts() {
        return accounts;
    }

    public void setAccounts(CounterpartyAccount[] accounts) {
        this.accounts = accounts;
    }
}
