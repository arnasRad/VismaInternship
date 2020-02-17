package com.arnasrad.vismainternship.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Counterparty {

    @JsonProperty("country")
    private String country;

    private String id;
    private String name;
    private String phone;
    private CounterpartyAccount[] accounts;

    public Counterparty() {
    }

    public Counterparty(String country, String id, String name, String phone, CounterpartyAccount[] accounts) {
        this.country = country;
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.accounts = accounts;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public CounterpartyAccount[] getAccounts() {
        return accounts;
    }

    public void setAccounts(CounterpartyAccount[] accounts) {
        this.accounts = accounts;
    }
}
