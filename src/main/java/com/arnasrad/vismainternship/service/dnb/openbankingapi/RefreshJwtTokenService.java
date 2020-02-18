package com.arnasrad.vismainternship.service.dnb.openbankingapi;

import com.arnasrad.vismainternship.token.DnbJwtToken;
import com.arnasrad.vismainternship.service.mapping.JsonMapperService;
import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.model.exception.BadRequestException;
import com.arnasrad.vismainternship.service.dnb.openbankingapi.builder.DnbRequestBuilderService;
import com.arnasrad.vismainternship.service.request.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class RefreshJwtTokenService implements TokenService {

    @Value("${dnb.openbanking.endpoint.access-token}")
    private String accessTokenEndpoint;

    private final RestTemplate restTemplate;
    private final DnbRequestBuilderService dnbRequestBuilderService;
    private final JsonMapperService jsonMapperService;
    private final DnbJwtToken dnbJwtToken;

    @Autowired
    public RefreshJwtTokenService(RestTemplate restTemplate, DnbRequestBuilderService dnbRequestBuilderService, JsonMapperService jsonMapperService, DnbJwtToken dnbJwtToken) {

        this.restTemplate = restTemplate;
        this.dnbRequestBuilderService = dnbRequestBuilderService;
        this.jsonMapperService = jsonMapperService;
        this.dnbJwtToken = dnbJwtToken;
    }

    @Override
    public String refreshAndGetToken(String ssn) throws BadRequestException {

        String jsonResponse = refreshToken(ssn);
        return setNewToken(jsonResponse);
    }

    private String refreshToken(String ssn) throws BadRequestException{

        return Optional.ofNullable(restTemplate.postForEntity(accessTokenEndpoint,
                dnbRequestBuilderService.getRequest(ssn), String.class).getBody())
                .orElseThrow(() -> new BadRequestException(String.format(ErrorMessages.BAD_REQUEST, "refreshToken")));
    }

    private String setNewToken(String jsonResponse) {

        String token = jsonMapperService.getFieldFromResponse(jsonResponse, "jwtToken");
        dnbJwtToken.setToken(token);
        return token;
    }

    @Override
    public String getBankId() {

        return BankId.DNB_ID.getBank();
    }
}
