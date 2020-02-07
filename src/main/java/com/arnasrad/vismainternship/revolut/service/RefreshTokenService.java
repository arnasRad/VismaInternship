package com.arnasrad.vismainternship.revolut.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class RefreshTokenService {
    @Value("${revolut.sandbox.constant.refreshToken}")
    private String refreshTokenConstant;

    @Value("${revolut.sandbox.constant.clientId}")
    private String clientId;

    @Value("${url.revolut.access.token}")
    private String refreshTokenUrl;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Refreshes the access token and returns the newly generated access token
     * @return refresh access token string
     */
    public String refreshToken() throws JsonProcessingException {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = setupParams();

        HttpEntity<MultiValueMap<String, String>> httpEntity
                = new HttpEntity<>(params, httpHeaders);

        String jsonResponse = restTemplate.exchange(refreshTokenUrl, HttpMethod.POST, httpEntity, String.class).getBody();

        if (jsonResponse != null) {
            // TODO: update access token property
            JsonNode parent = new ObjectMapper().readTree(jsonResponse);
            return parent.get("access_token").asText();
        } else {
            return null;
        }
    }

    private MultiValueMap<String, String> setupParams() {

        String jwtToken = jwtTokenService.generateToken();

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "refresh_token"); // value="refresh_token"
        params.add("refresh_token", refreshTokenConstant); // value=a_refresh_token
        params.add("client_id", clientId); // value=your_app_id
        params.add("client_assertion_type", "urn:ietf:params:oauth:client-assertion-type:jwt-bearer"); // value="urn:ietf:params:oauth:client-assertion-type:jwt-bearer"
        params.add("client_assertion", jwtToken); // value=generated_jwt_token

        return params;
    }
}
