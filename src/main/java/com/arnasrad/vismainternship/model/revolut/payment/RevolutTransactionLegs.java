package com.arnasrad.vismainternship.model.revolut.payment;

import com.arnasrad.vismainternship.model.payment.LegsCounterparty;
import com.arnasrad.vismainternship.model.payment.TransactionLegs;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RevolutTransactionLegs extends TransactionLegs {

    @JsonProperty("bill_amount")
    private Double billAmount;
    @JsonProperty("bill_currency")
    private String billCurrency;

    @ManyToOne
    @JoinColumn(name = "revolutTransactionId")
    private RevolutTransaction revolutTransaction;

    public RevolutTransactionLegs() {
    }

    public RevolutTransactionLegs(String id, Double amount, String currency, String accountId,
                                  LegsCounterparty counterparty, String description, Double balance,
                                  Double billAmount, String billCurrency, RevolutTransaction revolutTransaction) {

        super(id, amount, currency, accountId, counterparty, description, balance);
        this.billAmount = billAmount;
        this.billCurrency = billCurrency;
        this.revolutTransaction = revolutTransaction;
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

    public RevolutTransaction getRevolutTransaction() {
        return revolutTransaction;
    }

    public void setRevolutTransaction(RevolutTransaction revolutTransaction) {
        this.revolutTransaction = revolutTransaction;
    }
}
