package com.arnasrad.vismainternship.revolut.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Component("revolut-json-revolut-mapper")
public class JsonResponseMapper {

    @Value("${error.msg.json-mapper}")
    private String jsonResponseError;

    @Autowired
    private ObjectMapper mapper;

    private final Logger logger = LoggerFactory.getLogger(JsonResponseMapper.class);

    private JsonResponseMapper() {

    }

    public <T> T getObjectFromString(String jsonString, Class<T> type) {

        try {
            return mapper.readValue(jsonString, type);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, jsonResponseError);
        }
    }

    public <T> List<T> getObjectListFromString(String jsonString, Class<T> type) {

        JavaType listType = mapper.getTypeFactory().constructCollectionType(List.class, type);

        try {
            return mapper.readValue(jsonString, listType);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, jsonResponseError);
        }
    }
}
