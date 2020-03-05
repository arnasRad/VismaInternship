package com.arnasrad.vismainternship.model.dto.dnb.payment;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthenticationObject {
    @NotNull
    private String authenticationMethodId;
    @NotNull
    private String authenticationType;
    private String authenticationVersion;
    private String explanation;
    private String name;

    public String getAuthenticationMethodId() {
        return authenticationMethodId;
    }

    public void setAuthenticationMethodId(String authenticationMethodId) {
        this.authenticationMethodId = authenticationMethodId;
    }

    public String getAuthenticationType() {
        return authenticationType;
    }

    public void setAuthenticationType(String authenticationType) {
        this.authenticationType = authenticationType;
    }

    public String getAuthenticationVersion() {
        return authenticationVersion;
    }

    public void setAuthenticationVersion(String authenticationVersion) {
        this.authenticationVersion = authenticationVersion;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
