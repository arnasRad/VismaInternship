package com.arnasrad.vismainternship.mapper.customer;

import com.arnasrad.vismainternship.model.dto.customer.CustomerDTO;
import com.arnasrad.vismainternship.model.entity.customer.Customer;

public class CustomerMapper {

    public CustomerDTO mapToDTO(Customer entity) {
        return new CustomerDTO(entity.getCustomerName(), entity.getSsn());
    }

    public Customer mapToEntity(CustomerDTO dto) {
        return new Customer(dto.getCustomerName(), dto.getSsn());
    }
}
