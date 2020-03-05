package com.arnasrad.vismainternship.model.dto.dnb.account;

import com.arnasrad.vismainternship.model.enums.DnbAccountStatus;
import com.arnasrad.vismainternship.model.enums.DnbAccountUsage;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnbAccountDto extends RepresentationModel<DnbAccountDto> {

    private List<DnbBalance> balances;
    private String bban;
    private String bic;
    private String currency;
    private String iban;
    private String name;
    private DnbAccountStatus status;
    private DnbAccountUsage usage;

    public List<DnbBalance> getBalances() {
        return balances;
    }

    public void setBalances(List<DnbBalance> balances) {
        this.balances = balances;
    }

    public String getBban() {
        return bban;
    }

    public void setBban(String bban) {
        this.bban = bban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DnbAccountStatus getStatus() {
        return status;
    }

    public void setStatus(DnbAccountStatus status) {
        this.status = status;
    }

    public DnbAccountUsage getUsage() {
        return usage;
    }

    public void setUsage(DnbAccountUsage usage) {
        this.usage = usage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DnbAccountDto that = (DnbAccountDto) o;
        return Objects.equals(getBalances(), that.getBalances()) &&
                Objects.equals(getBban(), that.getBban()) &&
                Objects.equals(getBic(), that.getBic()) &&
                Objects.equals(getCurrency(), that.getCurrency()) &&
                Objects.equals(getIban(), that.getIban()) &&
                Objects.equals(getName(), that.getName()) &&
                getStatus() == that.getStatus() &&
                getUsage() == that.getUsage();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getBalances(), getBban(), getBic(), getCurrency(), getIban(),
                getName(), getStatus(), getUsage());
    }
}
