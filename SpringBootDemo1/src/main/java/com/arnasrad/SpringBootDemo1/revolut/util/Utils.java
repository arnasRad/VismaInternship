package com.arnasrad.SpringBootDemo1.revolut.util;

import com.arnasrad.SpringBootDemo1.revolut.Account;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Utils {

    public static List<Account> getAccountListFromJsonString(String jsonString)
            throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, Account.class);

        return mapper.readValue(jsonString, type);
    }
}
