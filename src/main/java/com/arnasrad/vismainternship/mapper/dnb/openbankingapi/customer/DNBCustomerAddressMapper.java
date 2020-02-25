package com.arnasrad.vismainternship.mapper.dnb.openbankingapi.customer;

import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer.DNBCustomerAddressDTO;
import com.arnasrad.vismainternship.model.entity.dnb.openbankingapi.customer.DNBCustomerAddress;

public class DNBCustomerAddressMapper {

    public DNBCustomerAddressDTO mapToDTO(DNBCustomerAddress entity) {
        return new DNBCustomerAddressDTO(entity.getPostalCode(), entity.getAddressLine1(),
                entity.getPostalAddressCountry(), entity.getPostalCodeName(), entity.getAddressLine2(),
                entity.getAddressLine3());
    }

    public DNBCustomerAddress mapToEntity(DNBCustomerAddressDTO dto) {
        return new DNBCustomerAddress(dto.getPostalCode(), dto.getAddressLine1(), dto.getPostalAddressCountry(),
                dto.getPostalCodeName(), dto.getAddressLine2(), dto.getAddressLine3());
    }
}
