package com.arnasrad.vismainternship.model.dto.revolut.account;

import com.arnasrad.vismainternship.model.dto.account.AccountDetailsDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RevolutAccountDetailsDto extends AccountDetailsDto {

    private String bic;
    private Boolean pooled;
    private String uniqueReference;

    @JsonProperty("sort_code")
    private String sortCode;

    @JsonProperty("routing_number")
    private String routingNumber;

    private String beneficiary;
    @JsonProperty("beneficiary_address")
    private BeneficiaryAddressDto beneficiaryAddress;

    @JsonProperty("estimated_time")
    private EstimatedTimeDto estimatedTime;

    public RevolutAccountDetailsDto() {
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
