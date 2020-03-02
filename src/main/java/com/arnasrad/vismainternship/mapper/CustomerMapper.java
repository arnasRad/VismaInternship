package com.arnasrad.vismainternship.mapper;

import com.arnasrad.vismainternship.model.dto.customer.CustomerDto;
import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer.DNBCustomerDto;
import com.arnasrad.vismainternship.model.entity.customer.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDto mapToCustomerDto(Customer entity) {
        CustomerDto customerDto = new CustomerDto();

        customerDto.setCustomerName(entity.getCustomerName());
        customerDto.setSsn(entity.getSsn());

        return customerDto;
    }

    public DNBCustomerDto mapToDNBCustomerDto(Customer entity) {
        DNBCustomerDto dnbCustomerDto = new DNBCustomerDto();

        dnbCustomerDto.setCustomerName(entity.getCustomerName());
        dnbCustomerDto.setSsn(entity.getSsn());

        return dnbCustomerDto;
    }

    public Customer mapToCustomerEntity(CustomerDto dto) {
        return new Customer(dto.getCustomerName(), dto.getSsn());
    }

    public Customer mapToCustomerEntity(DNBCustomerDto dto) {
        return new Customer(dto.getCustomerName(), dto.getSsn());
    }
}
