package com.arnasrad.vismainternship.model.dto.revolut.transaction;

import com.arnasrad.vismainternship.model.dto.transaction.TransactionLegsDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RevolutTransactionLegsDto extends TransactionLegsDto {

    @JsonProperty("bill_amount")
    private Double billAmount;
    @JsonProperty("bill_currency")
    private String billCurrency;

    public RevolutTransactionLegsDto() {
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
