package com.arnasrad.vismainternship.mapper.transaction;

import com.arnasrad.vismainternship.model.dto.transaction.LegsCounterpartyDTO;
import com.arnasrad.vismainternship.model.entity.transaction.LegsCounterparty;
import org.springframework.stereotype.Component;

@Component
public class LegsCounterpartyMapper {

    public LegsCounterpartyDTO mapToDTO(LegsCounterparty entity) {
        return new LegsCounterpartyDTO(entity.getAccountId(), entity.getAccountId(), entity.getType());
    }

    public LegsCounterparty mapToEntity(LegsCounterpartyDTO dto) {
        return new LegsCounterparty(dto.getId(), dto.getAccountId(), dto.getType());
    }
}
