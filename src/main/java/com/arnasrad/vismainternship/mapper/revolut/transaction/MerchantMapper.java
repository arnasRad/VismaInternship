package com.arnasrad.vismainternship.mapper.revolut.transaction;

import com.arnasrad.vismainternship.model.dto.revolut.transaction.MerchantDTO;
import com.arnasrad.vismainternship.model.entity.revolut.transaction.Merchant;


public class MerchantMapper {

    public MerchantDTO mapToDTO(Merchant entity) {
        return new MerchantDTO(entity.getName(), entity.getCity(), entity.getCategoryCode(), entity.getCountry());
    }

    public Merchant mapToEntity(MerchantDTO dto) {
        return new Merchant(dto.getName(), dto.getCity(), dto.getCategoryCode(), dto.getCountry());
    }
}
