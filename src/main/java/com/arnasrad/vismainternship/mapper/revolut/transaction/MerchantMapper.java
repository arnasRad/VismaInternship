package com.arnasrad.vismainternship.mapper.revolut.transaction;

import com.arnasrad.vismainternship.model.dto.revolut.transaction.MerchantDTO;
import com.arnasrad.vismainternship.model.entity.transaction.Merchant;
import org.springframework.stereotype.Component;

@Component
public class MerchantMapper {

    public MerchantDTO mapToDTO(Merchant entity) {
        if (entity == null) {
            return null;
        }

        return new MerchantDTO(entity.getName(), entity.getCity(), entity.getCategoryCode(), entity.getCountry());
    }

    public Merchant mapToEntity(MerchantDTO dto) {
        if (dto == null) {
            return null;
        }

        return new Merchant(dto.getName(), dto.getCity(), dto.getCategoryCode(), dto.getCountry());
    }
}
