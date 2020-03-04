package com.arnasrad.vismainternship.model.dto.dnb.account;

import com.arnasrad.vismainternship.model.enums.DnbBalanceType;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnbBalance {

    private DnbBalanceAmount balanceAmount;
    private DnbBalanceType balanceType;
    private Date lastChangeDateTime;
    private String lastCommittedTransaction;
    private Date referenceDate;

    public DnbBalance() {
    }

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

    public Date getLastChangeDateTime() {
        return lastChangeDateTime;
    }

    public void setLastChangeDateTime(Date lastChangeDateTime) {
        this.lastChangeDateTime = lastChangeDateTime;
    }

    public String getLastCommittedTransaction() {
        return lastCommittedTransaction;
    }

    public void setLastCommittedTransaction(String lastCommittedTransaction) {
        this.lastCommittedTransaction = lastCommittedTransaction;
    }

    public Date getReferenceDate() {
        return referenceDate;
    }

    public void setReferenceDate(Date referenceDate) {
        this.referenceDate = referenceDate;
    }
}
