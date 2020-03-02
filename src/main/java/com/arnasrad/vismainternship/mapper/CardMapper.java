package com.arnasrad.vismainternship.mapper;

import com.arnasrad.vismainternship.model.dto.card.CardDto;
import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.card.BlockingInfoDto;
import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.card.DNBCardDto;
import com.arnasrad.vismainternship.model.entity.card.BlockingInfo;
import com.arnasrad.vismainternship.model.entity.card.Card;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {

    public CardDto mapToCardDto(Card entity) {
        CardDto cardDto = new CardDto();

        cardDto.setCustomerId(entity.getCustomerId());
        cardDto.setCardId(entity.getCardId());
        cardDto.setAccountNumber(entity.getAccountNumber());
        cardDto.setCreditBalance(entity.getCreditBalance());
        cardDto.setDebitBalance(entity.getDebitBalance());
        cardDto.setCardType(entity.getCardType());
        cardDto.setProductName(entity.getProductName());

        return cardDto;
    }

    public DNBCardDto mapToDnbCardDto(Card entity) {
        DNBCardDto dnbCardDto = new DNBCardDto();
        BlockingInfoDto blockingInfoDto = mapToBlockingInfoDto(entity.getBlockingInfo());

        dnbCardDto.setCustomerId(entity.getCustomerId());
        dnbCardDto.setCardId(entity.getCardId());
        dnbCardDto.setAccountNumber(entity.getAccountNumber());
        dnbCardDto.setCreditBalance(entity.getCreditBalance());
        dnbCardDto.setDebitBalance(entity.getDebitBalance());
        dnbCardDto.setCardType(entity.getCardType());
        dnbCardDto.setProductName(entity.getProductName());
        dnbCardDto.setBlockingInfo(blockingInfoDto);
        dnbCardDto.setCreated(entity.getCreated());
        dnbCardDto.setLastChanged(entity.getLastChanged());
        dnbCardDto.setMaskedCardNumber(entity.getMaskedCardNumber());
        dnbCardDto.setCardHolderName(entity.getCardHolderName());
        dnbCardDto.setCardStatus(entity.getCardStatus());

        return dnbCardDto;
    }

    public BlockingInfoDto mapToBlockingInfoDto(BlockingInfo entity) {
        BlockingInfoDto blockingInfoDto = new BlockingInfoDto();

        blockingInfoDto.setUnblockAllowed(entity.isUnblockAllowed());
        blockingInfoDto.setBlockAllowed(entity.isBlockAllowed());
        blockingInfoDto.setPerformedBy(entity.getPerformedBy());
        blockingInfoDto.setTimestamp(entity.getTimestamp());

        return blockingInfoDto;
    }

    public Card mapToCardEntity(CardDto dto) {
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

    public Card mapToCardEntity(DNBCardDto dto) {
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

    public BlockingInfo mapToBlockingInfoEntity(BlockingInfoDto dto) {
        BlockingInfo blockingInfo = new BlockingInfo();

        blockingInfo.setUnblockAllowed(dto.isUnblockAllowed());
        blockingInfo.setPerformedBy(dto.getPerformedBy());
        blockingInfo.setTimestamp(dto.getTimestamp());
        blockingInfo.setBlockAllowed(dto.isBlockAllowed());

        return blockingInfo;
    }
}
