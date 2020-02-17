package com.arnasrad.vismainternship.service.dnb.psd2api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsentsService {

    private final UuidService uuidService;

    @Autowired
    public ConsentsService(UuidService uuidService) {
        this.uuidService = uuidService;
    }

    public String generateConsent() {

        return null;
    }
}
