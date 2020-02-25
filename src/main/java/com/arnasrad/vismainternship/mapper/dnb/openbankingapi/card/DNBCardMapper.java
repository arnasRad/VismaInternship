package com.arnasrad.vismainternship.mapper.dnb.openbankingapi.card;

import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.card.BlockingInfoDTO;
import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.card.DNBCardDTO;
import com.arnasrad.vismainternship.model.entity.dnb.openbankingapi.card.BlockingInfo;
import com.arnasrad.vismainternship.model.entity.dnb.openbankingapi.card.DNBCard;

public class DNBCardMapper {

    private final BlockingInfoMapper blockingInfoMapper;
    
    private DNBCardMapper(BlockingInfoMapper blockingInfoMapper) {
        this.blockingInfoMapper = blockingInfoMapper;
    }
    
    public DNBCardDTO mapToDTO(DNBCard entity) {
        BlockingInfoDTO blockingInfoDTO = blockingInfoMapper.mapToDTO(entity.getBlockingInfo());
        
        return new DNBCardDTO(entity.getCustomerId(), entity.getCardId(), entity.getAccountNumber(),
                entity.getCreditBalance(), entity.getDebitBalance(), entity.getCardType(), entity.getProductName(),
                blockingInfoDTO, entity.getCreated(), entity.getLastChanged(), entity.getMaskedCardNumber(),
                entity.getCardHolderName(), entity.getCardStatus());
    }

    public DNBCard mapToEntity(DNBCardDTO dto) {
        BlockingInfo blockingInfo = blockingInfoMapper.mapToEntity(dto.getBlockingInfo());

        return new DNBCard(dto.getCustomerId(), dto.getCardId(), dto.getAccountNumber(),
                dto.getCreditBalance(), dto.getDebitBalance(), dto.getCardType(), dto.getProductName(),
                blockingInfo, dto.getCreated(), dto.getLastChanged(), dto.getMaskedCardNumber(),
                dto.getCardHolderName(), dto.getCardStatus());
    }
}
