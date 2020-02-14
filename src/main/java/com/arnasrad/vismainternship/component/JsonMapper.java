package com.arnasrad.vismainternship.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class JsonMapper {

    @Value("${error.msg.json-mapper}")
    private String jsonResponseError;

    @Autowired
    private ObjectMapper mapper;

    private final Logger logger = LoggerFactory.getLogger(JsonMapper.class);

    public String getFieldFromResponse(String response, String field) {

        try {
            JsonNode parent = (new ObjectMapper()).readTree(response);
            return parent.get(field).asText();
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, jsonResponseError);
        }
    }

    public <T> String getStringFromObject(T object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, jsonResponseError);
        }
    }
}
