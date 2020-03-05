package com.arnasrad.vismainternship.model.dto.dnb.payment;

import com.arnasrad.vismainternship.model.dto.dnb.account.DnbAccountDto;
import com.arnasrad.vismainternship.model.enums.DnbTransactionStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.hateoas.RepresentationModel;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnbPaymentDetailsDto extends RepresentationModel<DnbAccountDto> {

    private AccountReference creditorAccount;
    private Address creditorAddress;
    private String creditorAgent;
    private String creditorName;
    private AccountReference debtorAccount;
    private String endToEndIdentification;
    private Amount instructedAmount;
    private String remittanceInformationUnstructured;
    private DnbTransactionStatus transactionStatus;

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

    public String getRemittanceInformationUnstructured() {
        return remittanceInformationUnstructured;
    }

    public void setRemittanceInformationUnstructured(String remittanceInformationUnstructured) {
        this.remittanceInformationUnstructured = remittanceInformationUnstructured;
    }

    public DnbTransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(DnbTransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}
