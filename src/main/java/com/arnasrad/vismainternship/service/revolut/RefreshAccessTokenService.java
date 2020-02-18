package com.arnasrad.vismainternship.service.revolut;

import com.arnasrad.vismainternship.service.mapping.JsonMapperService;
import com.arnasrad.vismainternship.token.RevolutAccessToken;
import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.model.exception.BadRequestException;
import com.arnasrad.vismainternship.service.request.TokenService;
import com.arnasrad.vismainternship.service.revolut.builder.RevolutRequestBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class RefreshAccessTokenService implements TokenService {

    @Value("${revolut.endpoint.access-token}")
    private String refreshTokenEndpoint;

    private final RevolutRequestBuilderService revolutRequestBuilderService;
    private final RestTemplate restTemplate;
    private final JsonMapperService jsonMapperService;
    private final RevolutAccessToken revolutAccessToken;

    @Autowired
    public RefreshAccessTokenService(RevolutRequestBuilderService revolutRequestBuilderService,
                                     RestTemplate restTemplate, JsonMapperService jsonMapperService, RevolutAccessToken revolutAccessToken) {

        this.revolutRequestBuilderService = revolutRequestBuilderService;
        this.restTemplate = restTemplate;
        this.jsonMapperService = jsonMapperService;
        this.revolutAccessToken = revolutAccessToken;
    }

    @Override
    public String refreshAndGetToken(String ssn) throws BadRequestException {

        String jsonResponse = refreshToken();
        return setNewToken(jsonResponse);
    }

    private String refreshToken() throws BadRequestException {

        return Optional.ofNullable(restTemplate.exchange(refreshTokenEndpoint, HttpMethod.POST,
                revolutRequestBuilderService.getAccessTokenRequest(), String.class).getBody()
        ).orElseThrow(() -> new BadRequestException(String.format(ErrorMessages.BAD_REQUEST, "refreshToken")));
    }

    private String setNewToken(String jsonResponse) {

        String token = jsonMapperService.getFieldFromResponse(jsonResponse, "access_token");
        revolutAccessToken.setToken(token);
        return token;
    }

    @Override
    public String getBankId() {

        return BankId.REVOLUT_ID.getBank();
    }
}
