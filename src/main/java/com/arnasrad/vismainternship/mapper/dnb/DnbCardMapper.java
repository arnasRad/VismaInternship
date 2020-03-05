package com.arnasrad.vismainternship.mapper.dnb;

import com.arnasrad.vismainternship.model.dto.CardDto;
import com.arnasrad.vismainternship.model.dto.dnb.card.BlockingInfoDto;
import com.arnasrad.vismainternship.model.dto.dnb.card.DnbCardDto;
import com.arnasrad.vismainternship.model.entity.card.BlockingInfo;
import com.arnasrad.vismainternship.model.entity.card.Card;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DnbCardMapper {

    public DnbCardDto mapToDnbCardDto(Card entity) {
        DnbCardDto dnbCardDto = new DnbCardDto();
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

    public CardDto mapToCardDto(DnbCardDto dnbCardDto) {
        CardDto cardDto = new CardDto();

        cardDto.setAccountNumber(dnbCardDto.getAccountNumber());
        cardDto.setCreditBalance(dnbCardDto.getCreditBalance());
        cardDto.setDebitBalance(dnbCardDto.getDebitBalance());

        return cardDto;
    }

    public List<CardDto> mapToCardDtoList(List<DnbCardDto> dnbCardDtoList) {
        List<CardDto> cardDtoList = new ArrayList<>();

        for(DnbCardDto dnbCardDto : dnbCardDtoList) {
            CardDto cardDto = mapToCardDto(dnbCardDto);
            cardDtoList.add(cardDto);
        }

        return cardDtoList;
    }

    public BlockingInfoDto mapToBlockingInfoDto(BlockingInfo entity) {
        BlockingInfoDto blockingInfoDto = new BlockingInfoDto();

        blockingInfoDto.setUnblockAllowed(entity.isUnblockAllowed());
        blockingInfoDto.setBlockAllowed(entity.isBlockAllowed());
        blockingInfoDto.setPerformedBy(entity.getPerformedBy());
        blockingInfoDto.setTimestamp(entity.getTimestamp());

        return blockingInfoDto;
    }

    public Card mapToCardEntity(DnbCardDto dto) {
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
