package com.arnasrad.vismainternship.dnb.component;

import com.arnasrad.vismainternship.dnb.openbanking.model.customer.Customer;
import com.arnasrad.vismainternship.dnb.openbanking.model.customer.CustomerInfo;
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

@Component("dnb-json-response-mapper")
public class JsonResponseMapper {

    @Value("${error.msg.json-mapper}")
    private String jsonResponseError;

    private static final Logger logger = LoggerFactory.getLogger(JsonResponseMapper.class);

    private JsonResponseMapper() {

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

    public <T> List<T> getListFromJsonString(String jsonString, Class<T> classType) {

        ObjectMapper mapper = new ObjectMapper();
        JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, classType);

        try {
            return mapper.readValue(jsonString, type);
        } catch (JsonProcessingException e) {
            logger.error(Arrays.toString(e.getStackTrace()));
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, jsonResponseError);
        }
    }
}
