package com.arnasrad.vismainternship.model.dto.dnb.psd2api;

public class DnbAccountDto {

    private String id;
    private String name;
    private Double balance;

    public DnbAccountDto() {

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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
