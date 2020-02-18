package com.arnasrad.vismainternship.model.enums;

public enum BankId {

    REVOLUT_ID("revolut"),
    DNB_ID("dnb");

    private String bank;

    BankId(String bank) {
        this.bank = bank;
    }

    public String getBank() {
        return bank;
    }
}
