package com.arnasrad.vismainternship.controller.dnb;

import com.arnasrad.vismainternship.service.dnb.openbankingapi.RefreshJwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtTokenController {

    private final RefreshJwtTokenService refreshJwtTokenService;

    @Autowired
    public JwtTokenController(RefreshJwtTokenService refreshJwtTokenService) {
        this.refreshJwtTokenService = refreshJwtTokenService;
    }

    @PostMapping("/dnb/refresh-token")
    public String getApiToken(String ssn) {

        return refreshJwtTokenService.refreshAndGetJwtToken(ssn);
    }
}
