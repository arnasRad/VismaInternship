package com.arnasrad.vismainternship.model.dto.dnb.account;

import com.arnasrad.vismainternship.model.enums.DnbBalanceType;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnbBalance {

    private DnbBalanceAmount balanceAmount;
    private DnbBalanceType balanceType;
    private String lastChangeDateTime;
    private String lastCommittedTransaction;
    private String referenceDate;

    public DnbBalanceAmount getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(DnbBalanceAmount balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public DnbBalanceType getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(DnbBalanceType balanceType) {
        this.balanceType = balanceType;
    }

    public String getLastChangeDateTime() {
        return lastChangeDateTime;
    }

    public void setLastChangeDateTime(String lastChangeDateTime) {
        this.lastChangeDateTime = lastChangeDateTime;
    }

    public String getLastCommittedTransaction() {
        return lastCommittedTransaction;
    }

    public void setLastCommittedTransaction(String lastCommittedTransaction) {
        this.lastCommittedTransaction = lastCommittedTransaction;
    }

    public String getReferenceDate() {
        return referenceDate;
    }

    public void setReferenceDate(String referenceDate) {
        this.referenceDate = referenceDate;
    }
}
