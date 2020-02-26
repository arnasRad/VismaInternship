package com.arnasrad.vismainternship.model.dto.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LegsCounterpartyDTO {

    private String id;
    @JsonProperty("account_id")
    private String accountId;
    private String type;

    public LegsCounterpartyDTO() {
    }

    public LegsCounterpartyDTO(String id, String accountId, String type) {
        this.id = id;
        this.accountId = accountId;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}