package com.arnasrad.vismainternship.mapper;

import com.arnasrad.vismainternship.model.dto.customer.CustomerDTO;
import com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer.DNBCustomerDTO;
import com.arnasrad.vismainternship.model.entity.customer.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDTO mapToCustomerDTO(Customer entity) {
        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setCustomerName(entity.getCustomerName());
        customerDTO.setSsn(entity.getSsn());

        return customerDTO;
    }

    public DNBCustomerDTO mapToDNBCustomerDTO(Customer entity) {
        DNBCustomerDTO dnbCustomerDTO = new DNBCustomerDTO();

        dnbCustomerDTO.setCustomerName(entity.getCustomerName());
        dnbCustomerDTO.setSsn(entity.getSsn());

        return dnbCustomerDTO;
    }

    public Customer mapToCustomerEntity(CustomerDTO dto) {
        return new Customer(dto.getCustomerName(), dto.getSsn());
    }

    public Customer mapToCustomerEntity(DNBCustomerDTO dto) {
        return new Customer(dto.getCustomerName(), dto.getSsn());
    }
}
