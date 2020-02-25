package com.arnasrad.vismainternship.model.entity.dnb.openbankingapi.card;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BlockingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean unblockAllowed;
    private String performedBy;
    private String timestamp;
    private boolean blockAllowed;

    public BlockingInfo() {
    }

    public BlockingInfo(boolean unblockAllowed, String performedBy, String timestamp, boolean blockAllowed) {
        this.unblockAllowed = unblockAllowed;
        this.performedBy = performedBy;
        this.timestamp = timestamp;
        this.blockAllowed = blockAllowed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
