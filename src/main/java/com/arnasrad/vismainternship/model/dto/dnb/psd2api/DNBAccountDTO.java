package com.arnasrad.vismainternship.model.dto.dnb.psd2api;

public class DNBAccountDTO {

    private String id;
    private String name;
    private Double balance;

    public DNBAccountDTO() {

    }

    public DNBAccountDTO(String id, String name, Double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
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
