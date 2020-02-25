package com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.card;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlockingInfoDTO {

    private boolean unblockAllowed;
    private String performedBy;
    private String timestamp;
    private boolean blockAllowed;

    public BlockingInfoDTO() {
    }

    public BlockingInfoDTO(boolean unblockAllowed, String performedBy, String timestamp, boolean blockAllowed) {
        this.unblockAllowed = unblockAllowed;
        this.performedBy = performedBy;
        this.timestamp = timestamp;
        this.blockAllowed = blockAllowed;
    }

    public boolean isUnblockAllowed() {
        return unblockAllowed;
    }

    public void setUnblockAllowed(boolean unblockAllowed) {
        this.unblockAllowed = unblockAllowed;
    }

    public String getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isBlockAllowed() {
        return blockAllowed;
    }

    public void setBlockAllowed(boolean blockAllowed) {
        this.blockAllowed = blockAllowed;
    }
}
