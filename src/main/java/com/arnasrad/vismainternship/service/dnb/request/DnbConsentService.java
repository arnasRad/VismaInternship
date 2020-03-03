package com.arnasrad.vismainternship.service.dnb.request;

import com.arnasrad.vismainternship.mapper.TokenMapper;
import com.arnasrad.vismainternship.model.dto.token.DnbConsentDto;
import com.arnasrad.vismainternship.model.dto.token.DnbConsentRequestDto;
import com.arnasrad.vismainternship.model.entity.token.Token;
import com.arnasrad.vismainternship.persistence.token.TokenRepository;
import com.arnasrad.vismainternship.service.dnb.builder.DnbPsd2RequestBuilderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DnbConsentService {

    @Value("${dnb.psd2.endpoint.contents}")
    private String consentsEndpoint;
    @Value("${dnb.psd2.psu-id}")
    private String psuId;
    private final RestTemplate restTemplate;
    private final DnbPsd2RequestBuilderService requestBuilderService;
    private final TokenRepository tokenRepository;
    private final TokenMapper tokenMapper;

    public DnbConsentService(RestTemplate restTemplate, DnbPsd2RequestBuilderService requestBuilderService,
                             TokenRepository tokenRepository, TokenMapper tokenMapper) {
        this.restTemplate = restTemplate;
        this.requestBuilderService = requestBuilderService;
        this.tokenRepository = tokenRepository;
        this.tokenMapper = tokenMapper;
    }

    public String getConsent(DnbConsentRequestDto consentRequestDto) throws JsonProcessingException {
        HttpEntity<String> httpEntity = requestBuilderService.getConsentRequest(consentRequestDto);

        ResponseEntity<DnbConsentDto> responseEntity = restTemplate.postForEntity(consentsEndpoint,
                httpEntity, DnbConsentDto.class);

        DnbConsentDto newToken = responseEntity.getBody();
        newToken.setClientId(psuId);
        save(newToken);

        Link scaRedirectLink = newToken.getLinks().getLink("scaRedirect").orElse(null);
        return scaRedirectLink.getHref();
    }

    private void save(DnbConsentDto consent) {
        Token token = tokenRepository.findById(consent.getClientId())
                .orElse(new Token());

        token = tokenMapper.mapToTokenEntity(token, consent);
        tokenRepository.save(token);
    }
}
