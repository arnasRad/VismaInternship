package com.arnasrad.vismainternship.model.dto.dnb.card;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlockingInfoDto {

    private boolean unblockAllowed;
    private String performedBy;
    private String timestamp;
    private boolean blockAllowed;

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
