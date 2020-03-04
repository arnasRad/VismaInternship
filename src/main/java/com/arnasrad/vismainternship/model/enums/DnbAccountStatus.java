package com.arnasrad.vismainternship.model.enums;

public enum DnbAccountStatus {

    ENABLED("enabled"),
    DELETED("deleted"),
    BLOCKED("blocked");

    private String status;

    DnbAccountStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}