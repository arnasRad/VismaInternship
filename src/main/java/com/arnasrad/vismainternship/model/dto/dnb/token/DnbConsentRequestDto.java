package com.arnasrad.vismainternship.model.dto.dnb.token;

public class DnbConsentRequestDto {

    private DnbConsentAccessDto access;
    private boolean combinedServiceIndicator;
    private int frequencyPerDay;
    private boolean recurringIndicator;
    private String validUntil;

    public DnbConsentAccessDto getAccess() {
        return access;
    }

    public void setAccess(DnbConsentAccessDto access) {
        this.access = access;
    }

    public boolean isCombinedServiceIndicator() {
        return combinedServiceIndicator;
    }

    public void setCombinedServiceIndicator(boolean combinedServiceIndicator) {
        this.combinedServiceIndicator = combinedServiceIndicator;
    }

    public int getFrequencyPerDay() {
        return frequencyPerDay;
    }

    public void setFrequencyPerDay(int frequencyPerDay) {
        this.frequencyPerDay = frequencyPerDay;
    }

    public boolean isRecurringIndicator() {
        return recurringIndicator;
    }

    public void setRecurringIndicator(boolean recurringIndicator) {
        this.recurringIndicator = recurringIndicator;
    }

    public String getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }
}
