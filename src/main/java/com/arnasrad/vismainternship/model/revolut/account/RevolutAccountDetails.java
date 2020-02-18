package com.arnasrad.vismainternship.model.revolut.account;

import com.arnasrad.vismainternship.model.interbankingapi.account.AccountDetails;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RevolutAccountDetails extends AccountDetails {

    private String bic;
    private Boolean pooled;
    private String uniqueReference;

    @JsonProperty("sort_code")
    private String sortCode;

    @JsonProperty("routing_number")
    private String routingNumber;

    private String beneficiary;
    @JsonProperty("beneficiary_address")
    private BeneficiaryAddress beneficiaryAddress;

    @JsonProperty("estimated_time")
    private EstimatedTime estimatedTime;

    public RevolutAccountDetails() {
    }

    public RevolutAccountDetails(String iban, String[] schemas, String accountNo, String bankCountry, String bic,
                                 Boolean pooled, String uniqueReference, String sortCode, String routingNumber,
                                 String beneficiary, BeneficiaryAddress beneficiaryAddress, EstimatedTime estimatedTime) {

        super(iban, schemas, accountNo, bankCountry);
        this.bic = bic;
        this.pooled = pooled;
        this.uniqueReference = uniqueReference;
        this.sortCode = sortCode;
        this.routingNumber = routingNumber;
        this.beneficiary = beneficiary;
        this.beneficiaryAddress = beneficiaryAddress;
        this.estimatedTime = estimatedTime;
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

    public EstimatedTime getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(EstimatedTime estimatedTime) {
        this.estimatedTime = estimatedTime;
    }
}
