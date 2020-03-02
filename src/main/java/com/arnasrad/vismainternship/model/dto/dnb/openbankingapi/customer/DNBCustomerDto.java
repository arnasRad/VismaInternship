package com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer;

import com.arnasrad.vismainternship.model.dto.customer.CustomerDto;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DNBCustomerDto extends CustomerDto {

    public DNBCustomerDto() {
    }

    public DNBCustomerDto(String customerName, String ssn) {
        super(customerName, ssn);
    }
}
