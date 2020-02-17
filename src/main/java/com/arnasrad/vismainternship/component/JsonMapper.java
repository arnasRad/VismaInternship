package com.arnasrad.vismainternship.component;

import com.arnasrad.vismainternship.service.ResponseStatusExceptionBuilderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("revolut-json-revolut-mapper")
public class JsonMapper {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private ResponseStatusExceptionBuilderService exceptionBuilder;

    private final Logger logger = LoggerFactory.getLogger(JsonMapper.class);

    private JsonMapper() {

    }

    public <T> T getObjectFromString(String jsonString, Class<T> type) {

        try {
            return mapper.readValue(jsonString, type);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            throw exceptionBuilder.getJsonException500();
        }
    }

    public <T> List<T> getObjectListFromString(String jsonString, Class<T> type) {

        JavaType listType = mapper.getTypeFactory().constructCollectionType(List.class, type);

        try {
            return mapper.readValue(jsonString, listType);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            throw exceptionBuilder.getJsonException500();
        }
    }

    public String getFieldFromResponse(String response, String field) {

        try {
            JsonNode parent = (new ObjectMapper()).readTree(response);
            return parent.get(field).asText();
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            throw exceptionBuilder.getJsonException500();
        }
    }

    public <T> String getStringFromObject(T object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            throw exceptionBuilder.getJsonException500();
        }
    }
}
