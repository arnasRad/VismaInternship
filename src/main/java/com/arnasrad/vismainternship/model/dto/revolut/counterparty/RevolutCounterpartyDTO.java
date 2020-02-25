package com.arnasrad.vismainternship.model.dto.revolut.counterparty;

import com.arnasrad.vismainternship.model.dto.counterparty.CounterpartyAccountDTO;
import com.arnasrad.vismainternship.model.dto.counterparty.CounterpartyDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RevolutCounterpartyDTO extends CounterpartyDTO {

    @JsonProperty("profile_type")
    private String profileType;
    private String state;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("updated_at")
    private Date updatedAt;

    public RevolutCounterpartyDTO() {
    }

    public RevolutCounterpartyDTO(String country, String id, String name, String phone,
                                  List<RevolutCounterpartyAccountDTO> accounts, String profileType, String state,
                                  Date createdAt, Date updatedAt) {
        super(country, id, name, phone, accounts);
        this.profileType = profileType;
        this.state = state;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getProfileType() {
        return profileType;
    }

    public void setProfileType(String profileType) {
        this.profileType = profileType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<RevolutCounterpartyAccountDTO> getRevolutAccounts() {

        List<CounterpartyAccountDTO> counterpartyAccounts = super.getAccounts();
        List<RevolutCounterpartyAccountDTO> revolutCounterpartyAccounts = new ArrayList<>();

        for (CounterpartyAccountDTO counterpartyAccount : counterpartyAccounts) {
            revolutCounterpartyAccounts.add((RevolutCounterpartyAccountDTO) counterpartyAccount);
        }

        return revolutCounterpartyAccounts;
    }
}
