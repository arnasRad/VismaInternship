package com.arnasrad.vismainternship.revolut.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class RefreshTokenService {

    @Value("${url.revolut.access.token}")
    private String refreshTokenUrl;

    @Autowired
    private RequestBuilderService requestBuilderService;

    @Autowired
    private RestTemplate restTemplate;

    private final Logger logger = LoggerFactory.getLogger(RefreshTokenService.class);

    public String refreshAndGetAccessToken() {

        String jsonResponse = restTemplate.exchange(refreshTokenUrl, HttpMethod.POST,
                requestBuilderService.getJwtHttpEntity(),
                String.class).getBody();

        if (jsonResponse != null) {
            // TODO: update access token property
            try {
                JsonNode parent = new ObjectMapper().readTree(jsonResponse);
                return parent.get("access_token").asText();
            } catch (JsonProcessingException e) {
                logger.error(Arrays.toString(e.getStackTrace()));
                return null; // TODO: return Optional
            }
        } else {
            logger.warn("null response returned on refresh access token query");
            return null; // TODO: return Optional
        }
    }
}
