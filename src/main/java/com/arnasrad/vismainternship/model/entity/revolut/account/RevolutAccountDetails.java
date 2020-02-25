package com.arnasrad.vismainternship.model.entity.revolut.account;

import com.arnasrad.vismainternship.model.entity.account.AccountDetails;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
public class RevolutAccountDetails extends AccountDetails {

    private String bic;
    private Boolean pooled;
    private String uniqueReference;
    private String sortCode;
    private String routingNumber;
    private String beneficiary;
    @ManyToOne
    private BeneficiaryAddress beneficiaryAddress;
    @ManyToOne
    private EstimatedTime estimatedTime;

    public RevolutAccountDetails() {
    }

    public RevolutAccountDetails(String iban, List<String> schemas, String accountNo, String bankCountry, String bic,
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
