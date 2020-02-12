package com.arnasrad.vismainternship.dnb.psd2.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UuidService {

    public String getUUID() {

        return UUID.randomUUID().toString();
    }
}
