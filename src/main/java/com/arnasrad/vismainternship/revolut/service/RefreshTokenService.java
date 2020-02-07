package com.arnasrad.vismainternship.revolut.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RefreshTokenService {

    @Value("${url.revolut.access.token}")
    private String refreshTokenUrl;

    @Autowired
    private RequestBuilderService requestBuilderService;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Refreshes the access token and returns the newly generated access token
     *
     * @return refresh access token string
     */
    public String refreshToken() {

        String jsonResponse = restTemplate.exchange(refreshTokenUrl, HttpMethod.POST,
                requestBuilderService.getJwtHttpEntity(),
                String.class).getBody();

        if (jsonResponse != null) {
            // TODO: update access token property
            try {
                JsonNode parent = new ObjectMapper().readTree(jsonResponse);
                return parent.get("access_token").asText();
            } catch (JsonProcessingException e) { // TODO: use logger
                e.printStackTrace();
                return null; // TODO: return Optional
            }
        } else {
            return null; // TODO: return Optional
        }
    }
}
