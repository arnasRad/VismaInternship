package com.arnasrad.vismainternship.model.entity.revolut.counterparty;

import com.arnasrad.vismainternship.model.entity.counterparty.CounterpartyAccount;

import javax.persistence.Entity;

@Entity
public class RevolutCounterpartyAccount extends CounterpartyAccount {

    private String iban;
    private String sortCode;
    private String routingNumber;
    private String bic;
    private String recipientCharges;

    public RevolutCounterpartyAccount() {
    }

    public RevolutCounterpartyAccount(String counterpartyAccountId, String currency, String type,
                                      String accountNo, String iban, String sortCode, String routingNumber,
                                      String bic, String recipientCharges) {
        super(counterpartyAccountId, currency, type, accountNo);
        this.iban = iban;
        this.sortCode = sortCode;
        this.routingNumber = routingNumber;
        this.bic = bic;
        this.recipientCharges = recipientCharges;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getRecipientCharges() {
        return recipientCharges;
    }

    public void setRecipientCharges(String recipientCharges) {
        this.recipientCharges = recipientCharges;
    }
}
