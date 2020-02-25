package com.arnasrad.vismainternship.mapper.dnb.openbankingapi.customer;

import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer.DNBCustomerDTO;
import com.arnasrad.vismainternship.model.entity.dnb.openbankingapi.customer.DNBCustomer;


public class DNBCustomerMapper {

    public DNBCustomerDTO mapToDTO(DNBCustomer entity) {
        return new DNBCustomerDTO(entity.getCustomerName(), entity.getSsn());
    }

    public DNBCustomer mapToEntity(DNBCustomerDTO dto) {
        return new DNBCustomer(dto.getCustomerName(), dto.getSsn());
    }
}
