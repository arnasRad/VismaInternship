package com.arnasrad.vismainternship.model.dto.counterparty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CounterpartyDTO {

    private String id;

    @JsonProperty("country")
    private String country;

    private String name;
    private String phone;
    private CounterpartyAccountDTO[] accounts;

    public CounterpartyDTO() {
    }

    public CounterpartyDTO(String country, String id, String name, String phone, CounterpartyAccountDTO[] accounts) {
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

    public CounterpartyAccountDTO[] getAccounts() {
        return accounts;
    }

    public void setAccounts(CounterpartyAccountDTO[] accounts) {
        this.accounts = accounts;
    }
}
