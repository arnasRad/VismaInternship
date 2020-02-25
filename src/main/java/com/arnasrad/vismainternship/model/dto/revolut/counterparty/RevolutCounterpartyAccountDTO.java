package com.arnasrad.vismainternship.model.dto.revolut.counterparty;

import com.arnasrad.vismainternship.model.dto.counterparty.CounterpartyAccountDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RevolutCounterpartyAccountDTO extends CounterpartyAccountDTO {

    private String iban;
    @JsonProperty("sort_no")
    private String sortCode;
    @JsonProperty("routing_number")
    private String routingNumber;
    private String bic;
    @JsonProperty("recipient_charges")
    private String recipientCharges;

    public RevolutCounterpartyAccountDTO() {
    }

    public RevolutCounterpartyAccountDTO(String id, String currency, String type, String accountNo, String iban,
                                         String sortCode, String routingNumber, String bic, String recipientCharges) {
        super(id, currency, type, accountNo);
        this.iban = iban;
        this.sortCode = sortCode;
        this.routingNumber = routingNumber;
        this.bic = bic;
        this.recipientCharges = recipientCharges;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
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

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getRecipientCharges() {
        return recipientCharges;
    }

    public void setRecipientCharges(String recipientCharges) {
        this.recipientCharges = recipientCharges;
    }
}
