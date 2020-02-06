package com.arnasrad.SpringBootDemo1.revolut.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
public class RefreshTokenService {
    @Value("${revolut.sandbox.refreshToken.constant")
    private String refreshTokenConstant;

    @Value("${revolut.sandbox.constant.clientId")
    private String clientId;

    @Autowired
    private JwtTokenService jwtTokenService;

    public void refreshToken() {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        String jwtToken = jwtTokenService.generateToken();

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "refresh_token"); // value="refresh_token"
        map.add("refresh_token", refreshTokenConstant); // value=a_refresh_token
        map.add("client_id", clientId); // value=your_app_id
        map.add("client_assertion_type", "urn:ietf:params:oauth:client-assertion-type:jwt-bearer"); // value="urn:ietf:params:oauth:client-assertion-type:jwt-bearer"
        map.add("client_assertion", jwtToken); // value=generated_jwt_token

        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

    }
}
