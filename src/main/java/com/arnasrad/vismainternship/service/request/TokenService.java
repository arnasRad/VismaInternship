package com.arnasrad.vismainternship.service.request;

public interface TokenService {

    String refreshAndGetToken(String ssn);

    String refreshToken(String ssn);

    String setNewToken(String jsonResponse);
}
