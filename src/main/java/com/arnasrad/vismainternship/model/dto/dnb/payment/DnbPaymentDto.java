package com.arnasrad.vismainternship.model.dto.dnb.payment;

import com.arnasrad.vismainternship.model.enums.DnbTransactionStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnbPaymentDto extends RepresentationModel<DnbPaymentDto> {

    private ChallengeData challengeData;
    private AuthenticationObject chosenScaMethod;
    private String paymentId;
    private String psuMessage;
    private List<AuthenticationObject> scaMethods;
    private List<TppMessageGeneric> tppMessages;
    private Boolean transactionFeeIndicator;
    private Amount transactionFees;
    private DnbTransactionStatus transactionStatus;

    public ChallengeData getChallengeData() {
        return challengeData;
    }

    public void setChallengeData(ChallengeData challengeData) {
        this.challengeData = challengeData;
    }

    public AuthenticationObject getChosenScaMethod() {
        return chosenScaMethod;
    }

    public void setChosenScaMethod(AuthenticationObject chosenScaMethod) {
        this.chosenScaMethod = chosenScaMethod;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPsuMessage() {
        return psuMessage;
    }

    public void setPsuMessage(String psuMessage) {
        this.psuMessage = psuMessage;
    }

    public List<AuthenticationObject> getScaMethods() {
        return scaMethods;
    }

    public void setScaMethods(List<AuthenticationObject> scaMethods) {
        this.scaMethods = scaMethods;
    }

    public List<TppMessageGeneric> getTppMessages() {
        return tppMessages;
    }

    public void setTppMessages(List<TppMessageGeneric> tppMessages) {
        this.tppMessages = tppMessages;
    }

    public Boolean getTransactionFeeIndicator() {
        return transactionFeeIndicator;
    }

    public void setTransactionFeeIndicator(Boolean transactionFeeIndicator) {
        this.transactionFeeIndicator = transactionFeeIndicator;
    }

    public Amount getTransactionFees() {
        return transactionFees;
    }

    public void setTransactionFees(Amount transactionFees) {
        this.transactionFees = transactionFees;
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
        DnbPaymentDto that = (DnbPaymentDto) o;
        return Objects.equals(getChallengeData(), that.getChallengeData()) &&
                Objects.equals(getChosenScaMethod(), that.getChosenScaMethod()) &&
                Objects.equals(getPaymentId(), that.getPaymentId()) &&
                Objects.equals(getPsuMessage(), that.getPsuMessage()) &&
                Objects.equals(getScaMethods(), that.getScaMethods()) &&
                Objects.equals(getTppMessages(), that.getTppMessages()) &&
                Objects.equals(getTransactionFeeIndicator(), that.getTransactionFeeIndicator()) &&
                Objects.equals(getTransactionFees(), that.getTransactionFees()) &&
                getTransactionStatus() == that.getTransactionStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getChallengeData(), getChosenScaMethod(), getPaymentId(),
                getPsuMessage(), getScaMethods(), getTppMessages(), getTransactionFeeIndicator(),
                getTransactionFees(), getTransactionStatus());
    }
}
