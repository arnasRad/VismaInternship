package com.arnasrad.vismainternship.model.dto.dnb.customer;

import com.arnasrad.vismainternship.model.dto.customer.CustomerDto;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnbCustomerDto extends CustomerDto {

    public DnbCustomerDto() {
    }

}
