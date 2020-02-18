package com.arnasrad.vismainternship.service.dnb.openbankingapi;

import com.arnasrad.vismainternship.component.JsonMapper;
import com.arnasrad.vismainternship.component.dnb.JwtToken;
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
    private final JsonMapper jsonMapper;
    private final JwtToken jwtToken;

    @Autowired
    public RefreshJwtTokenService(RestTemplate restTemplate, DnbRequestBuilderService dnbRequestBuilderService, JsonMapper jsonMapper, JwtToken jwtToken) {

        this.restTemplate = restTemplate;
        this.dnbRequestBuilderService = dnbRequestBuilderService;
        this.jsonMapper = jsonMapper;
        this.jwtToken = jwtToken;
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

        String token = jsonMapper.getFieldFromResponse(jsonResponse, "jwtToken");
        jwtToken.setToken(token);
        return token;
    }

    @Override
    public String getBankId() {

        return BankId.DNB_ID.getBank();
    }
}
