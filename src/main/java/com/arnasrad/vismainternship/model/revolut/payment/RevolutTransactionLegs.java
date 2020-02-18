package com.arnasrad.vismainternship.model.revolut.payment;

import com.arnasrad.vismainternship.model.payment.LegsCounterparty;
import com.arnasrad.vismainternship.model.payment.TransactionLegs;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RevolutTransactionLegs extends TransactionLegs {

    @JsonProperty("leg_id")
    private String legId;
    @JsonProperty("bill_amount")
    private Double billAmount;
    @JsonProperty("bill_currency")
    private String billCurrency;

    public RevolutTransactionLegs() {
    }

    public RevolutTransactionLegs(String id, Double amount, String currency, String accountId,
                                  LegsCounterparty counterparty, String description, Double balance, String legId,
                                  Double billAmount, String billCurrency) {

        super(id, amount, currency, accountId, counterparty, description, balance);
        this.legId = legId;
        this.billAmount = billAmount;
        this.billCurrency = billCurrency;
    }

    public String getLegId() {
        return legId;
    }

    public void setLegId(String legId) {
        this.legId = legId;
    }

    public Double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
    }

    public String getBillCurrency() {
        return billCurrency;
    }

    public void setBillCurrency(String billCurrency) {
        this.billCurrency = billCurrency;
    }
}
