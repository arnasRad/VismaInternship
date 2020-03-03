package com.arnasrad.vismainternship.model.dto.token;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.hateoas.RepresentationModel;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnbConsentDto extends RepresentationModel<DnbConsentDto> {

    private String consentId;
    private String consentStatus;
//    @JsonProperty("_links")
//    private Link links;
    private String clientId;

    public DnbConsentDto() {
    }

    public String getConsentId() {
        return consentId;
    }

    public void setConsentId(String consentId) {
        this.consentId = consentId;
    }

    public String getConsentStatus() {
        return consentStatus;
    }

    public void setConsentStatus(String consentStatus) {
        this.consentStatus = consentStatus;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
