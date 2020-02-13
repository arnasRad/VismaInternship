package com.arnasrad.vismainternship.revolut.controller;

import com.arnasrad.vismainternship.revolut.service.RefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    @Autowired
    RefreshTokenService refreshTokenService;

    @GetMapping("/revolut/refresh-token")
    public String getNewAccessToken() {

        return refreshTokenService.refreshAndGetAccessToken();
    }
}
