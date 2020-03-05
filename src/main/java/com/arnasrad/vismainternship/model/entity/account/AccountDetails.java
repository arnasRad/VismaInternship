package com.arnasrad.vismainternship.model.entity.account;

import javax.persistence.*;
import java.util.List;

@Entity
public class AccountDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNo;
    private String iban;
    @ElementCollection
    private List<String> schemas;
    private String bankCountry;
    private String bic;
    private Boolean pooled;
    private String uniqueReference;
    private String sortCode;
    private String routingNumber;
    private String beneficiary;
    private String usage;
    @ManyToOne
    private BeneficiaryAddress beneficiaryAddress;
    @ManyToOne
    private EstimatedTime estimatedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public EstimatedTime getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(EstimatedTime estimatedTime) {
        this.estimatedTime = estimatedTime;
    }
}
