package com.arnasrad.vismainternship.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentRequestDto implements Serializable {

    private String bankName;
    private String debtor;
    private PaymentAccountReference creditor;
    private PaymentAmount instructedAmount;
    private String reference;
    private String paymentProduct;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getDebtor() {
        return debtor;
    }

    public void setDebtor(String debtor) {
        this.debtor = debtor;
    }

    public PaymentAccountReference getCreditor() {
        return creditor;
    }

    public void setCreditor(PaymentAccountReference creditor) {
        this.creditor = creditor;
    }

    public PaymentAmount getInstructedAmount() {
        return instructedAmount;
    }

    public void setInstructedAmount(PaymentAmount instructedAmount) {
        this.instructedAmount = instructedAmount;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getPaymentProduct() {
        return paymentProduct;
    }

    public void setPaymentProduct(String paymentProduct) {
        this.paymentProduct = paymentProduct;
    }
}
