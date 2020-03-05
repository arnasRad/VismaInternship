package com.arnasrad.vismainternship.model.dto.dnb.payment;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RemittanceInformationStructured implements Serializable {
    @NotNull
    private String reference;
    private String referenceIssuer;
    private String referenceType;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReferenceIssuer() {
        return referenceIssuer;
    }

    public void setReferenceIssuer(String referenceIssuer) {
        this.referenceIssuer = referenceIssuer;
    }

    public String getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType;
    }
}
