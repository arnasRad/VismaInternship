package com.arnasrad.vismainternship.model.dto.dnb.token;

import java.util.List;

public class DnbConsentAccessDto {

    private List<DnbConsentAccountDto> accounts;
    private List<DnbConsentAccountDto> balances;
    private List<DnbConsentAccountDto> transactions;

    public List<DnbConsentAccountDto> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<DnbConsentAccountDto> accounts) {
        this.accounts = accounts;
    }

    public List<DnbConsentAccountDto> getBalances() {
        return balances;
    }

    public void setBalances(List<DnbConsentAccountDto> balances) {
        this.balances = balances;
    }

    public List<DnbConsentAccountDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<DnbConsentAccountDto> transactions) {
        this.transactions = transactions;
    }
}
