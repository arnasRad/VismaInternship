package com.arnasrad.vismainternship.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Component("revolut-json-revolut-mapper")
public class JsonMapper {

    private final ObjectMapper mapper;

    private final Logger logger = LoggerFactory.getLogger(JsonMapper.class);

    @Autowired
    public JsonMapper(ObjectMapper mapper) {

        this.mapper = mapper;
    }

    public <T> T getObjectFromString(String jsonString, Class<T> type) {

        try {
            return mapper.readValue(jsonString, type);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error occurred while deserializing " +
                    "JSON string to object");
        }
    }

    public <T> List<T> getObjectListFromString(String jsonString, Class<T> type) {

        JavaType listType = mapper.getTypeFactory().constructCollectionType(List.class, type);

        try {
            return mapper.readValue(jsonString, listType);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error occurred while deserializing " +
                    "JSON string to object list");
        }
    }

    public String getFieldFromResponse(String response, String field) {

        try {
            JsonNode parent = (new ObjectMapper()).readTree(response);
            return parent.get(field).asText();
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error occurred while getting field " +
                    "from JSON string");
        }
    }

    public <T> String getStringFromObject(T object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error occurred while serializing " +
                    "object to JSON string");
        }
    }
}
