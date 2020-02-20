package com.arnasrad.vismainternship.model.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LegsCounterparty {

    @Id
    private String id;
    @JsonProperty("account_id")
    private String accountId;
    private String type;

    public LegsCounterparty() {
    }

    public LegsCounterparty(String id, String accountId, String type) {
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
