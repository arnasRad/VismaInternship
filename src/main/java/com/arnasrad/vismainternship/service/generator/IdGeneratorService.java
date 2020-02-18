package com.arnasrad.vismainternship.service.generator;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class IdGeneratorService {

    @Value("${constant.request-id.min-length}")
    private int requestIdMinLength;

    @Value("${constant.request-id.max-length}")
    private int requestIdMaxLength;

    private final RandomNumberGeneratorService numberGenerator;

    @Autowired
    public IdGeneratorService(RandomNumberGeneratorService numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public String generateRequestId() {

        int length = numberGenerator.generateRandomIntInRange(requestIdMinLength, requestIdMaxLength);
        return generateRandomId(length);
    }

    private String generateRandomId(int length) {

        return RandomStringUtils.randomAlphanumeric(length);
    }
}
