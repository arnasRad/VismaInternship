package com.arnasrad.vismainternship.model.dto.dnb.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnbAccountDtoWrapper extends RepresentationModel<DnbAccountDto>  {

    private List<DnbAccountDto> accounts;

    public List<DnbAccountDto> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<DnbAccountDto> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DnbAccountDtoWrapper that = (DnbAccountDtoWrapper) o;
        return Objects.equals(getAccounts(), that.getAccounts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAccounts());
    }
}
