package com.arnasrad.vismainternship.model.dto.dnb.payment;

import com.arnasrad.vismainternship.model.dto.dnb.account.DnbAccountDto;
import com.arnasrad.vismainternship.model.enums.DnbTransactionStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DnbPaymentDetailsDto that = (DnbPaymentDetailsDto) o;
        return Objects.equals(getCreditorAccount(), that.getCreditorAccount()) &&
                Objects.equals(getCreditorAddress(), that.getCreditorAddress()) &&
                Objects.equals(getCreditorAgent(), that.getCreditorAgent()) &&
                Objects.equals(getCreditorName(), that.getCreditorName()) &&
                Objects.equals(getDebtorAccount(), that.getDebtorAccount()) &&
                Objects.equals(getEndToEndIdentification(), that.getEndToEndIdentification()) &&
                Objects.equals(getInstructedAmount(), that.getInstructedAmount()) &&
                Objects.equals(getRemittanceInformationUnstructured(), that.getRemittanceInformationUnstructured()) &&
                getTransactionStatus() == that.getTransactionStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCreditorAccount(), getCreditorAddress(), getCreditorAgent(),
                getCreditorName(), getDebtorAccount(), getEndToEndIdentification(), getInstructedAmount(),
                getRemittanceInformationUnstructured(), getTransactionStatus());
    }
}
