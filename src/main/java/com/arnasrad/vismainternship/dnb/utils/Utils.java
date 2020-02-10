package com.arnasrad.vismainternship.dnb.utils;

import com.arnasrad.vismainternship.dnb.model.Customer;
import com.arnasrad.vismainternship.dnb.model.CustomerInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Utils {

    public static List<Customer> getCustomerListFromJsonString(String jsonString)
            throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, Customer.class);

        return mapper.readValue(jsonString, type);
    }

    public static CustomerInfo getCustomerInfoFromJsonString(String jsonString)
            throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(jsonString, CustomerInfo.class);
    }
}