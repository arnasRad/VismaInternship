package com.arnasrad.vismainternship.model.dto.revolut.transaction;

import com.arnasrad.vismainternship.model.dto.transaction.LegsCounterpartyDTO;
import com.arnasrad.vismainternship.model.dto.transaction.TransactionLegsDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RevolutTransactionLegsDTO extends TransactionLegsDTO {

    @JsonProperty("bill_amount")
    private Double billAmount;
    @JsonProperty("bill_currency")
    private String billCurrency;

    public RevolutTransactionLegsDTO() {
    }

    public RevolutTransactionLegsDTO(String id, Double amount, String currency, String accountId,
                                     LegsCounterpartyDTO counterparty, String description, Double balance,
                                     Double billAmount, String billCurrency) {
        super(id, amount, currency, accountId, counterparty, description, balance);
        this.billAmount = billAmount;
        this.billCurrency = billCurrency;
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
