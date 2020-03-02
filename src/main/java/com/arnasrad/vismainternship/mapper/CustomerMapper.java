package com.arnasrad.vismainternship.mapper;

import com.arnasrad.vismainternship.model.dto.customer.CustomerDto;
import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer.DnbCustomerDto;
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

    public DnbCustomerDto mapToDNBCustomerDto(Customer entity) {
        DnbCustomerDto dnbCustomerDto = new DnbCustomerDto();

        dnbCustomerDto.setCustomerName(entity.getCustomerName());
        dnbCustomerDto.setSsn(entity.getSsn());

        return dnbCustomerDto;
    }

    public Customer mapToCustomerEntity(CustomerDto dto) {
        Customer customer = new Customer();

        customer.setCustomerName(dto.getCustomerName());
        customer.setSsn(dto.getSsn());

        return customer;
    }

    public Customer mapToCustomerEntity(DnbCustomerDto dto) {
        Customer customer = new Customer();

        customer.setCustomerName(dto.getCustomerName());
        customer.setSsn(dto.getSsn());

        return customer;
    }
}
