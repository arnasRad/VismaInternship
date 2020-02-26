package com.arnasrad.vismainternship.mapper.revolut.account;

import com.arnasrad.vismainternship.model.dto.revolut.account.EstimatedTimeDTO;
import com.arnasrad.vismainternship.model.entity.account.EstimatedTime;
import org.springframework.stereotype.Component;

@Component
public class EstimatedTimeMapper {

    public EstimatedTimeDTO mapToDTO(EstimatedTime entity) {
        return new EstimatedTimeDTO(entity.getUnit(), entity.getMin(), entity.getMax());
    }

    public EstimatedTime mapToEntity(EstimatedTimeDTO dto) {
        return new EstimatedTime(dto.getUnit(), dto.getMin(), dto.getMax());
    }
}
