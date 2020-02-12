package com.arnasrad.vismainternship.dnb.controller;

import com.arnasrad.vismainternship.dnb.openbanking.service.RefreshJwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtTokenController {

    @Autowired
    private RefreshJwtTokenService refreshJwtTokenService;

    @PostMapping("/dnb/api-token")
    public String getApiToken() {

        return refreshJwtTokenService.refreshAndGetJwtToken();
    }
}
