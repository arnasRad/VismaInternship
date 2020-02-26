package com.arnasrad.vismainternship.mapper.revolut.account;

import com.arnasrad.vismainternship.model.dto.revolut.account.BeneficiaryAddressDTO;
import com.arnasrad.vismainternship.model.entity.account.BeneficiaryAddress;
import org.springframework.stereotype.Component;

@Component
public class BeneficiaryAddressMapper {

    public BeneficiaryAddressDTO mapToDTO(BeneficiaryAddress entity) {
        return new BeneficiaryAddressDTO(entity.getStreetLine1(), entity.getStreetLine2(), entity.getRegion(),
                entity.getCity(), entity.getCountry(), entity.getPostcode());
    }

    public BeneficiaryAddress mapToEntity(BeneficiaryAddressDTO dto) {
        return new BeneficiaryAddress(dto.getStreetLine1(), dto.getStreetLine2(), dto.getRegion(), dto.getCity(),
                dto.getCountry(), dto.getPostcode());
    }
}
