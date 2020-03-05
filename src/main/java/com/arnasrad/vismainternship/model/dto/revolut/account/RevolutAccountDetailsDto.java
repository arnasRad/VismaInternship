package com.arnasrad.vismainternship.model.dto.revolut.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RevolutAccountDetailsDto {

    @JsonProperty("account_no")
    private String accountNo;
    private String iban;
    private String bic;
    private String uniqueReference;
    private Boolean pooled;
    private List<String> schemas;
    @JsonProperty("bank_country")
    private String bankCountry;
    @JsonProperty("sort_code")
    private String sortCode;
    @JsonProperty("routing_number")
    private String routingNumber;
    private String beneficiary;
    @JsonProperty("beneficiary_address")
    private BeneficiaryAddressDto beneficiaryAddress;
    @JsonProperty("estimated_time")
    private EstimatedTimeDto estimatedTime;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
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

    public String getUniqueReference() {
        return uniqueReference;
    }

    public void setUniqueReference(String uniqueReference) {
        this.uniqueReference = uniqueReference;
    }

    public Boolean getPooled() {
        return pooled;
    }

    public void setPooled(Boolean pooled) {
        this.pooled = pooled;
    }

    public List<String> getSchemas() {
        return schemas;
    }

    public void setSchemas(List<String> schemas) {
        this.schemas = schemas;
    }

    public String getBankCountry() {
        return bankCountry;
    }

    public void setBankCountry(String bankCountry) {
        this.bankCountry = bankCountry;
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

    public BeneficiaryAddressDto getBeneficiaryAddress() {
        return beneficiaryAddress;
    }

    public void setBeneficiaryAddress(BeneficiaryAddressDto beneficiaryAddress) {
        this.beneficiaryAddress = beneficiaryAddress;
    }

    public EstimatedTimeDto getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(EstimatedTimeDto estimatedTime) {
        this.estimatedTime = estimatedTime;
    }
}
