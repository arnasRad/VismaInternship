package com.arnasrad.vismainternship.model.dto.dnb.payment;


import com.arnasrad.vismainternship.model.enums.DnbAccountPurposeCode;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnbPaymentRequestDto {
    @NotNull
    private AccountReference creditorAccount;
    private Address creditorAddress;
    private String creditorAgent;
    @NotNull
    private String creditorName;
    @NotNull
    private AccountReference debtorAccount;
    private String endToEndIdentification;
    @NotNull
    private Amount instructedAmount;
    private DnbAccountPurposeCode purposeCode;
    private RemittanceInformationStructured remittanceInformationStructured;
    private String remittanceInformationUnstructured;
    private String requestedExecutionDate;
    private String ultimateCreditor;
    private String ultimateDebtor;
    @JsonIgnore
    private String paymentProduct;

    public AccountReference getCreditorAccount() {
        return creditorAccount;
    }

    public void setCreditorAccount(AccountReference creditorAccount) {
        this.creditorAccount = creditorAccount;
    }

    public Address getCreditorAddress() {
        return creditorAddress;
    }

    public void setCreditorAddress(Address creditorAddress) {
        this.creditorAddress = creditorAddress;
    }

    public String getCreditorAgent() {
        return creditorAgent;
    }

    public void setCreditorAgent(String creditorAgent) {
        this.creditorAgent = creditorAgent;
    }

    public String getCreditorName() {
        return creditorName;
    }

    public void setCreditorName(String creditorName) {
        this.creditorName = creditorName;
    }

    public AccountReference getDebtorAccount() {
        return debtorAccount;
    }

    public void setDebtorAccount(AccountReference debtorAccount) {
        this.debtorAccount = debtorAccount;
    }

    public String getEndToEndIdentification() {
        return endToEndIdentification;
    }

    public void setEndToEndIdentification(String endToEndIdentification) {
        this.endToEndIdentification = endToEndIdentification;
    }

    public Amount getInstructedAmount() {
        return instructedAmount;
    }

    public void setInstructedAmount(Amount instructedAmount) {
        this.instructedAmount = instructedAmount;
    }

    public DnbAccountPurposeCode getPurposeCode() {
        return purposeCode;
    }

    public void setPurposeCode(DnbAccountPurposeCode purposeCode) {
        this.purposeCode = purposeCode;
    }

    public RemittanceInformationStructured getRemittanceInformationStructured() {
        return remittanceInformationStructured;
    }

    public void setRemittanceInformationStructured(RemittanceInformationStructured remittanceInformationStructured) {
        this.remittanceInformationStructured = remittanceInformationStructured;
    }

    public String getRemittanceInformationUnstructured() {
        return remittanceInformationUnstructured;
    }

    public void setRemittanceInformationUnstructured(String remittanceInformationUnstructured) {
        this.remittanceInformationUnstructured = remittanceInformationUnstructured;
    }

    public String getRequestedExecutionDate() {
        return requestedExecutionDate;
    }

    public void setRequestedExecutionDate(String requestedExecutionDate) {
        this.requestedExecutionDate = requestedExecutionDate;
    }

    public String getUltimateCreditor() {
        return ultimateCreditor;
    }

    public void setUltimateCreditor(String ultimateCreditor) {
        this.ultimateCreditor = ultimateCreditor;
    }

    public String getUltimateDebtor() {
        return ultimateDebtor;
    }

    public void setUltimateDebtor(String ultimateDebtor) {
        this.ultimateDebtor = ultimateDebtor;
    }

    public String getPaymentProduct() {
        return paymentProduct;
    }

    public void setPaymentProduct(String paymentProduct) {
        this.paymentProduct = paymentProduct;
    }
}
