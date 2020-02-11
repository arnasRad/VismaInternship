package com.arnasrad.vismainternship.dnb.component;

import com.arnasrad.vismainternship.dnb.model.Customer;
import com.arnasrad.vismainternship.dnb.model.CustomerInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@Component
public class DnbJsonResponseMapper {

    @Value("${error.msg.json-mapper-error}")
    private String jsonResponseError;

    private static final Logger logger = LoggerFactory.getLogger(DnbJsonResponseMapper.class);

    private DnbJsonResponseMapper() {

    }

    public List<Customer> getCustomerListFromJsonString(String jsonString) {

        ObjectMapper mapper = new ObjectMapper();
        JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, Customer.class);

        try {
            return mapper.readValue(jsonString, type);
        } catch (JsonProcessingException e) {
            logger.error(Arrays.toString(e.getStackTrace()));
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, jsonResponseError);
        }
    }

    public CustomerInfo getCustomerInfoFromJsonString(String jsonString) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(jsonString, CustomerInfo.class);
        } catch (JsonProcessingException e) {
            logger.error(Arrays.toString(e.getStackTrace()));
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, jsonResponseError);
        }
    }
}
