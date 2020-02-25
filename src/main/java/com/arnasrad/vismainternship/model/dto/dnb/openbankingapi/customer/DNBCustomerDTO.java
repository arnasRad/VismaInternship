package com.arnasrad.vismainternship.model.dto.dnb.openbankingapi.customer;

import com.arnasrad.vismainternship.model.dto.customer.CustomerDTO;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DNBCustomerDTO extends CustomerDTO {

    public DNBCustomerDTO() {
    }

    public DNBCustomerDTO(String customerName, String ssn) {
        super(customerName, ssn);
    }
}
