package com.arnasrad.vismainternship.model.dto.customer;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDto {

    private String ssn;
    private String customerName;

    public CustomerDto() {
    }

    public CustomerDto(String customerName, String ssn) {
        this.customerName = customerName;
        this.ssn = ssn;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
}
