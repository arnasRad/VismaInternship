package com.arnasrad.vismainternship.mapper.customer;

import com.arnasrad.vismainternship.model.dto.customer.CustomerAddressDTO;
import com.arnasrad.vismainternship.model.entity.customer.CustomerAddress;

public class CustomerAddressMapper {

    public CustomerAddressDTO mapToDTO(CustomerAddress entity) {
        return new CustomerAddressDTO(entity.getPostalCode(), entity.getAddressLine1());
    }

    public CustomerAddress mapToEntity(CustomerAddressDTO dto) {
        return new CustomerAddress(dto.getPostalCode(), dto.getAddressLine1());
    }
}
