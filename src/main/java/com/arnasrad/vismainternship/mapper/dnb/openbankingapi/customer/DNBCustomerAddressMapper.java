package com.arnasrad.vismainternship.mapper.dnb.openbankingapi.customer;

import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer.DNBCustomerAddressDTO;
import com.arnasrad.vismainternship.model.entity.customer.CustomerAddress;
import org.springframework.stereotype.Component;

@Component
public class DNBCustomerAddressMapper {

    public DNBCustomerAddressDTO mapToDTO(CustomerAddress entity) {
        return new DNBCustomerAddressDTO(entity.getPostalCode(), entity.getAddressLine1(),
                entity.getPostalAddressCountry(), entity.getPostalCodeName(), entity.getAddressLine2(),
                entity.getAddressLine3());
    }

    public CustomerAddress mapToEntity(DNBCustomerAddressDTO dto) {
        return new CustomerAddress(dto.getPostalCode(), dto.getAddressLine1(), dto.getPostalAddressCountry(),
                dto.getPostalCodeName(), dto.getAddressLine2(), dto.getAddressLine3());
    }
}
