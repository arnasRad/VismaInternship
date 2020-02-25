package com.arnasrad.vismainternship.model.entity.revolut.transaction;

import com.arnasrad.vismainternship.model.entity.transaction.LegsCounterparty;
import com.arnasrad.vismainternship.model.entity.transaction.TransactionLegs;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class RevolutTransactionLegs extends TransactionLegs {

    private Double billAmount;
    private String billCurrency;
    @ManyToOne
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
