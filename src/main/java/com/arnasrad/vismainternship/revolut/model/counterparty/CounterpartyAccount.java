package com.arnasrad.vismainternship.revolut.model.counterparty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CounterpartyAccount {

    private String id;
    private String currency;
    private String type;
    @JsonProperty("account_no")
    private String accountNo;
    private String iban;
    @JsonProperty("sort_no")
    private String sortCode;
    @JsonProperty("routing_number")
    private String routingNumber;
    private String bic;
    @JsonProperty("recipient_charges")
    private String recipientCharges;

    public CounterpartyAccount() {
    }

    public CounterpartyAccount(String id, String currency, String type, String accountNo, String iban, String sortCode, String routingNumber, String bic, String recipientCharges) {
        this.id = id;
        this.currency = currency;
        this.type = type;
        this.accountNo = accountNo;
        this.iban = iban;
        this.sortCode = sortCode;
        this.routingNumber = routingNumber;
        this.bic = bic;
        this.recipientCharges = recipientCharges;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
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
