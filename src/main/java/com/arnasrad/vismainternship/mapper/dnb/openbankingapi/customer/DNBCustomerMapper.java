package com.arnasrad.vismainternship.mapper.dnb.openbankingapi.customer;

import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer.DNBCustomerDTO;
import com.arnasrad.vismainternship.model.entity.customer.Customer;
import org.springframework.stereotype.Component;

@Component
public class DNBCustomerMapper {

    public DNBCustomerDTO mapToDTO(Customer entity) {
        return new DNBCustomerDTO(entity.getCustomerName(), entity.getSsn());
    }

    public Customer mapToEntity(DNBCustomerDTO dto) {
        return new Customer(dto.getCustomerName(), dto.getSsn());
    }
}
