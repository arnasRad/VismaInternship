package com.arnasrad.vismainternship.revolut.component;

import com.arnasrad.vismainternship.revolut.model.Account;
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

@Component("revolut-mapper")
public class JsonResponseMapper {

    @Value("${error.msg.json-mapper-error}")
    private String jsonResponseError;

    private final Logger logger = LoggerFactory.getLogger(JsonResponseMapper.class);

    private JsonResponseMapper() {

    }

    public List<Account> getAccountList(String jsonString) {

        ObjectMapper mapper = new ObjectMapper();
        JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, Account.class);

        try {
            return mapper.readValue(jsonString, type);
        } catch (JsonProcessingException e) {
            logger.error(Arrays.toString(e.getStackTrace()));
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, jsonResponseError);
        }
    }
}
