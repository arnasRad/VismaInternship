package com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.card;

import com.arnasrad.vismainternship.model.dto.card.CardDTO;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DNBCardDTO extends CardDTO {

    private BlockingInfoDTO blockingInfo;
    private String created;
    private String lastChanged;
    private String maskedCardNumber;
    private String cardHolderName;
    private String cardStatus;

    public DNBCardDTO() {
    }

    public DNBCardDTO(String customerId, String cardId, String accountNumber, String creditBalance,
                      String debitBalance, String cardType, String productName, BlockingInfoDTO blockingInfo,
                      String created, String lastChanged, String maskedCardNumber, String cardHolderName,
                      String cardStatus) {
        super(customerId, cardId, accountNumber, creditBalance, debitBalance, cardType, productName);
        this.blockingInfo = blockingInfo;
        this.created = created;
        this.lastChanged = lastChanged;
        this.maskedCardNumber = maskedCardNumber;
        this.cardHolderName = cardHolderName;
        this.cardStatus = cardStatus;
    }

    public BlockingInfoDTO getBlockingInfo() {
        return blockingInfo;
    }

    public void setBlockingInfo(BlockingInfoDTO blockingInfo) {
        this.blockingInfo = blockingInfo;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLastChanged() {
        return lastChanged;
    }

    public void setLastChanged(String lastChanged) {
        this.lastChanged = lastChanged;
    }

    public String getMaskedCardNumber() {
        return maskedCardNumber;
    }

    public void setMaskedCardNumber(String maskedCardNumber) {
        this.maskedCardNumber = maskedCardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }
}
