package com.arnasrad.vismainternship.revolut.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDetails {

    private String iban;
    private String bic;
    private Boolean pooled;
    private String uniqueReference;
    private String[] schemas;

    @JsonProperty("account_no")
    private String accountNo;

    @JsonProperty("sort_code")
    private String sortCode;

    @JsonProperty("routing_number")
    private String routingNumber;

    private String beneficiary;
    @JsonProperty("beneficiary_address")
    private BeneficiaryAddress beneficiaryAddress;

    @JsonProperty("bank_country")
    private String bankCountry;

    @JsonProperty("estimated_time")
    private EstimatedTime estimatedTime;

    public AccountDetails() {
    }

    public AccountDetails(String iban, String bic, Boolean pooled, String uniqueReference, String[] schemas, String accountNo, String sortCode, String routingNumber, String beneficiary, BeneficiaryAddress beneficiaryAddress, String bankCountry, EstimatedTime estimatedTime) {
        this.iban = iban;
        this.bic = bic;
        this.pooled = pooled;
        this.uniqueReference = uniqueReference;
        this.schemas = schemas;
        this.accountNo = accountNo;
        this.sortCode = sortCode;
        this.routingNumber = routingNumber;
        this.beneficiary = beneficiary;
        this.beneficiaryAddress = beneficiaryAddress;
        this.bankCountry = bankCountry;
        this.estimatedTime = estimatedTime;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public Boolean getPooled() {
        return pooled;
    }

    public void setPooled(Boolean pooled) {
        this.pooled = pooled;
    }

    public String getUniqueReference() {
        return uniqueReference;
    }

    public void setUniqueReference(String uniqueReference) {
        this.uniqueReference = uniqueReference;
    }

    public String[] getSchemas() {
        return schemas;
    }

    public void setSchemas(String[] schemas) {
        this.schemas = schemas;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public BeneficiaryAddress getBeneficiaryAddress() {
        return beneficiaryAddress;
    }

    public void setBeneficiaryAddress(BeneficiaryAddress beneficiaryAddress) {
        this.beneficiaryAddress = beneficiaryAddress;
    }

    public String getBankCountry() {
        return bankCountry;
    }

    public void setBankCountry(String bankCountry) {
        this.bankCountry = bankCountry;
    }

    public EstimatedTime getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(EstimatedTime estimatedTime) {
        this.estimatedTime = estimatedTime;
    }
}
