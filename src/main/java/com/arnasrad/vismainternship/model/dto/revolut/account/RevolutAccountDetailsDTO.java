package com.arnasrad.vismainternship.model.dto.revolut.account;

import com.arnasrad.vismainternship.model.dto.account.AccountDetailsDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RevolutAccountDetailsDTO extends AccountDetailsDTO {

    private String bic;
    private Boolean pooled;
    private String uniqueReference;

    @JsonProperty("sort_code")
    private String sortCode;

    @JsonProperty("routing_number")
    private String routingNumber;

    private String beneficiary;
    @JsonProperty("beneficiary_address")
    private BeneficiaryAddressDTO beneficiaryAddress;

    @JsonProperty("estimated_time")
    private EstimatedTimeDTO estimatedTime;

    public RevolutAccountDetailsDTO() {
    }

    public RevolutAccountDetailsDTO(String iban, List<String> schemas, String accountNo, String bankCountry, String bic,
                                    Boolean pooled, String uniqueReference, String sortCode, String routingNumber,
                                    String beneficiary, BeneficiaryAddressDTO beneficiaryAddress,
                                    EstimatedTimeDTO estimatedTime) {

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

    public BeneficiaryAddressDTO getBeneficiaryAddress() {
        return beneficiaryAddress;
    }

    public void setBeneficiaryAddress(BeneficiaryAddressDTO beneficiaryAddress) {
        this.beneficiaryAddress = beneficiaryAddress;
    }

    public EstimatedTimeDTO getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(EstimatedTimeDTO estimatedTime) {
        this.estimatedTime = estimatedTime;
    }
}
