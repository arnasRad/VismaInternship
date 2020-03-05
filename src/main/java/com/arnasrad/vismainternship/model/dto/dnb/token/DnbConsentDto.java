package com.arnasrad.vismainternship.model.dto.dnb.token;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnbConsentDto extends RepresentationModel<DnbConsentDto> {

    private String consentId;
    private String consentStatus;
    private String clientId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DnbConsentDto that = (DnbConsentDto) o;
        return Objects.equals(getConsentId(), that.getConsentId()) &&
                Objects.equals(getConsentStatus(), that.getConsentStatus()) &&
                Objects.equals(getClientId(), that.getClientId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getConsentId(), getConsentStatus(), getClientId());
    }
}
