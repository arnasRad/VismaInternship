package com.arnasrad.vismainternship.mapper.customer;

import com.arnasrad.vismainternship.model.dto.customer.CustomerAddressDTO;
import com.arnasrad.vismainternship.model.dto.customer.CustomerInfoDTO;
import com.arnasrad.vismainternship.model.entity.customer.CustomerAddress;
import com.arnasrad.vismainternship.model.entity.customer.CustomerInfo;

public class CustomerInfoMapper {

    private final CustomerAddressMapper customerAddressMapper;

    private CustomerInfoMapper(CustomerAddressMapper customerAddressMapper) {
        this.customerAddressMapper = customerAddressMapper;
    }

    public CustomerInfoDTO mapToDTO(CustomerInfo entity) {
        CustomerAddressDTO customerAddressDTO = customerAddressMapper.mapToDTO(entity.getAddress());

        return new CustomerInfoDTO(entity.getCustomerId(), entity.getFirstName(), entity.getLastName(),
                customerAddressDTO, entity.getPhone(), entity.getEmail(), entity.getCountryOfBirth());
    }

    public CustomerInfo mapToEntity(CustomerInfoDTO dto) {
        CustomerAddress customerAddress = customerAddressMapper.mapToEntity(dto.getAddress());

        return new CustomerInfo(dto.getCustomerId(), dto.getFirstName(), dto.getLastName(), customerAddress,
                dto.getPhone(), dto.getEmail(), dto.getCountryOfBirth());
    }
}
