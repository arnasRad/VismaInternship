package com.arnasrad.vismainternship.model.enums;

public enum MessageState {

    ACCEPTED("ACCEPTED"),
    IN_QUEUE("IN_QUEUE"),
    PROCESSING("PROCESSING"),
    PROCESSED("PROCESSED");

    private String state;

    MessageState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}