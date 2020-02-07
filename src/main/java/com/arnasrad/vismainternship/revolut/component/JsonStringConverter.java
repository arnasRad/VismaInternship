package com.arnasrad.vismainternship.revolut.component;

import com.arnasrad.vismainternship.revolut.model.Account;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JsonStringConverter {

    private JsonStringConverter() {
        // singleton scope component
    }

    public static List<Account> getAccountList(String jsonString)
            throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, Account.class);

        return mapper.readValue(jsonString, type);
    }
}
