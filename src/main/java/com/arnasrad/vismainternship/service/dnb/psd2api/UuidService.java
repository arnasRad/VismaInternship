package com.arnasrad.vismainternship.service.dnb.psd2api;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UuidService {

    public String getUUID() {

        return UUID.randomUUID().toString();
    }
}
