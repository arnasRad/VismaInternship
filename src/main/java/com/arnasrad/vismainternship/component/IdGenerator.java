package com.arnasrad.vismainternship.component;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class IdGenerator {

    @Value("${constant.request-id.min-length}")
    private int requestIdMinLength;

    @Value("${constant.request-id.max-length}")
    private int requestIdMaxLength;

    @Autowired
    private RandomNumberGenerator numberGenerator;

    public String generateRequestId() {

        int length = numberGenerator.generateRandomIntInRange(requestIdMinLength, requestIdMaxLength);
        return generateRandomId(length);
    }

    private String generateRandomId(int length) {

        return RandomStringUtils.random(length);
    }
}
