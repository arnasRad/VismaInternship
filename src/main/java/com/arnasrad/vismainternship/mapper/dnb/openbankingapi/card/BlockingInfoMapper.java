package com.arnasrad.vismainternship.mapper.dnb.openbankingapi.card;

import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.card.BlockingInfoDTO;
import com.arnasrad.vismainternship.model.entity.dnb.openbankingapi.card.BlockingInfo;

public class BlockingInfoMapper {

    public BlockingInfoDTO mapToDTO(BlockingInfo entity) {
        return new BlockingInfoDTO(entity.isUnblockAllowed(), entity.getPerformedBy(), entity.getTimestamp(), entity.isBlockAllowed());
    }

    public BlockingInfo mapToEntity(BlockingInfoDTO dto) {
        return new BlockingInfo(dto.isUnblockAllowed(), dto.getPerformedBy(), dto.getTimestamp(), dto.isBlockAllowed());
    }
}
