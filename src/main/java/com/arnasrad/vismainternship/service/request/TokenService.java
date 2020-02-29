package com.arnasrad.vismainternship.service.request;

public interface TokenService {

    void refresh();

    String get();

    String getBankId();
}
