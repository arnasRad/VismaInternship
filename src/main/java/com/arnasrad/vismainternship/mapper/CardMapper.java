package com.arnasrad.vismainternship.mapper;

import com.arnasrad.vismainternship.model.dto.card.CardDTO;
import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.card.BlockingInfoDTO;
import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.card.DNBCardDTO;
import com.arnasrad.vismainternship.model.entity.card.BlockingInfo;
import com.arnasrad.vismainternship.model.entity.card.Card;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {

    public CardDTO mapToCardDTO(Card entity) {
        CardDTO cardDTO = new CardDTO();

        cardDTO.setCustomerId(entity.getCustomerId());
        cardDTO.setCardId(entity.getCardId());
        cardDTO.setAccountNumber(entity.getAccountNumber());
        cardDTO.setCreditBalance(entity.getCreditBalance());
        cardDTO.setDebitBalance(entity.getDebitBalance());
        cardDTO.setCardType(entity.getCardType());
        cardDTO.setProductName(entity.getProductName());

        return cardDTO;
    }

    public DNBCardDTO mapToDnbCardDTO(Card entity) {
        DNBCardDTO dnbCardDTO = new DNBCardDTO();
        BlockingInfoDTO blockingInfoDTO = mapToBlockingInfoDTO(entity.getBlockingInfo());

        dnbCardDTO.setCustomerId(entity.getCustomerId());
        dnbCardDTO.setCardId(entity.getCardId());
        dnbCardDTO.setAccountNumber(entity.getAccountNumber());
        dnbCardDTO.setCreditBalance(entity.getCreditBalance());
        dnbCardDTO.setDebitBalance(entity.getDebitBalance());
        dnbCardDTO.setCardType(entity.getCardType());
        dnbCardDTO.setProductName(entity.getProductName());
        dnbCardDTO.setBlockingInfo(blockingInfoDTO);
        dnbCardDTO.setCreated(entity.getCreated());
        dnbCardDTO.setLastChanged(entity.getLastChanged());
        dnbCardDTO.setMaskedCardNumber(entity.getMaskedCardNumber());
        dnbCardDTO.setCardHolderName(entity.getCardHolderName());
        dnbCardDTO.setCardStatus(entity.getCardStatus());

        return dnbCardDTO;
    }

    public BlockingInfoDTO mapToBlockingInfoDTO(BlockingInfo entity) {
        BlockingInfoDTO blockingInfoDTO = new BlockingInfoDTO();

        blockingInfoDTO.setUnblockAllowed(entity.isUnblockAllowed());
        blockingInfoDTO.setBlockAllowed(entity.isBlockAllowed());
        blockingInfoDTO.setPerformedBy(entity.getPerformedBy());
        blockingInfoDTO.setTimestamp(entity.getTimestamp());

        return blockingInfoDTO;
    }

    public Card mapToCardEntity(CardDTO dto) {
        Card card = new Card();

        card.setCardId(dto.getCardId());
        card.setCustomerId(dto.getCustomerId());
        card.setAccountNumber(dto.getAccountNumber());
        card.setCreditBalance(dto.getCreditBalance());
        card.setDebitBalance(dto.getDebitBalance());
        card.setCardType(dto.getCardType());
        card.setProductName(dto.getProductName());

        return card;
    }

    public Card mapToCardEntity(DNBCardDTO dto) {
        Card card = new Card();
        BlockingInfo blockingInfo = mapToBlockingInfoEntity(dto.getBlockingInfo());

        card.setCustomerId(dto.getCustomerId());
        card.setCardId(dto.getCardId());
        card.setAccountNumber(dto.getAccountNumber());
        card.setCreditBalance(dto.getCreditBalance());
        card.setDebitBalance(dto.getDebitBalance());
        card.setCardType(dto.getCardType());
        card.setProductName(dto.getProductName());
        card.setBlockingInfo(blockingInfo);
        card.setCreated(dto.getCreated());
        card.setLastChanged(dto.getLastChanged());
        card.setMaskedCardNumber(dto.getMaskedCardNumber());
        card.setCardHolderName(dto.getCardHolderName());
        card.setCardStatus(dto.getCardStatus());

        return card;
    }

    public BlockingInfo mapToBlockingInfoEntity(BlockingInfoDTO dto) {
        BlockingInfo blockingInfo = new BlockingInfo();

        blockingInfo.setUnblockAllowed(dto.isUnblockAllowed());
        blockingInfo.setPerformedBy(dto.getPerformedBy());
        blockingInfo.setTimestamp(dto.getTimestamp());
        blockingInfo.setBlockAllowed(dto.isBlockAllowed());

        return blockingInfo;
    }
}
