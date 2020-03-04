package com.arnasrad.vismainternship.model.enums;

public enum DnbBalanceType {

    CLOSING_BOOKED("closingBooked"),
    EXPECTED("expected"),
    AUTHORIZED("authorized"),
    OPENING_BOOKED("openingBooked"),
    INTERIM_AVAILABLE("interimAvailable"),
    FORWARD_AVAILABLE("forwardAvailable"),
    NON_INVOICED("nonInvoiced");

    private String balanceType;

    DnbBalanceType(String balanceType) {
        this.balanceType = balanceType;
    }

    public String getBalanceType() {
        return balanceType;
    }
}
