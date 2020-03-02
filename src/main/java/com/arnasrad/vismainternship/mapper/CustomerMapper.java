package com.arnasrad.vismainternship.mapper;

import com.arnasrad.vismainternship.model.dto.customer.CustomerDto;
import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer.DNBCustomerDto;
import com.arnasrad.vismainternship.model.entity.customer.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDto mapToCustomerDTO(Customer entity) {
        CustomerDto customerDTO = new CustomerDto();

        customerDTO.setCustomerName(entity.getCustomerName());
        customerDTO.setSsn(entity.getSsn());

        return customerDTO;
    }

    public DNBCustomerDto mapToDNBCustomerDTO(Customer entity) {
        DNBCustomerDto dnbCustomerDTO = new DNBCustomerDto();

        dnbCustomerDTO.setCustomerName(entity.getCustomerName());
        dnbCustomerDTO.setSsn(entity.getSsn());

        return dnbCustomerDTO;
    }

    public Customer mapToCustomerEntity(CustomerDto dto) {
        return new Customer(dto.getCustomerName(), dto.getSsn());
    }

    public Customer mapToCustomerEntity(DNBCustomerDto dto) {
        return new Customer(dto.getCustomerName(), dto.getSsn());
    }
}
