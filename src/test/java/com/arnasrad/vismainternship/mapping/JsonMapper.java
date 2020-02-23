package com.arnasrad.vismainternship.mapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;

import java.util.List;

public class JsonMapper {

    private final ObjectMapper mapper = new ObjectMapper();

    public JsonMapper() {

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);

        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
    }

    public <T> List<T> getObjectListFromString(String jsonString, Class<T> type) {

        JavaType listType = mapper.getTypeFactory().constructCollectionType(List.class, type);

        try {
            return mapper.readValue(jsonString, listType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T> T getObjectFromString(String jsonString, Class<T> type) {

        try {
            return mapper.readValue(jsonString, type);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
