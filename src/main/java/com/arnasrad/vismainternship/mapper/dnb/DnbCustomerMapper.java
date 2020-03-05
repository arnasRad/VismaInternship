package com.arnasrad.vismainternship.mapper.dnb;

import com.arnasrad.vismainternship.model.dto.CustomerDto;
import com.arnasrad.vismainternship.model.dto.dnb.customer.DnbCustomerDto;
import com.arnasrad.vismainternship.model.entity.customer.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DnbCustomerMapper {

    public DnbCustomerDto mapToDNBCustomerDto(Customer entity) {
        DnbCustomerDto dnbCustomerDto = new DnbCustomerDto();

        dnbCustomerDto.setCustomerName(entity.getCustomerName());
        dnbCustomerDto.setSsn(entity.getSsn());

        return dnbCustomerDto;
    }

    public CustomerDto mapToCustomerDto(DnbCustomerDto dnbCustomerDto) {
        CustomerDto customerDto = new CustomerDto();

        customerDto.setId(dnbCustomerDto.getSsn());

        return customerDto;
    }

    public List<CustomerDto> mapToCustomerDtoList(List<DnbCustomerDto> dnbCustomerDtoList) {
        List<CustomerDto> customerDtoList = new ArrayList<>();

        for(DnbCustomerDto dnbCustomerDto : dnbCustomerDtoList) {
            CustomerDto customerDto = mapToCustomerDto(dnbCustomerDto);
            customerDtoList.add(customerDto);
        }

        return customerDtoList;
    }

    public Customer mapToCustomerEntity(DnbCustomerDto dto) {
        Customer customer = new Customer();

        customer.setCustomerName(dto.getCustomerName());
        customer.setSsn(dto.getSsn());

        return customer;
    }
}
