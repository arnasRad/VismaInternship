package com.arnasrad.vismainternship.revolut.controller;

import com.arnasrad.vismainternship.revolut.service.JwtTokenService;
import com.arnasrad.vismainternship.revolut.service.RefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    @Autowired
    RefreshTokenService refreshTokenService;

    @Autowired
    JwtTokenService jwtTokenService;

    @GetMapping("/refresh-access-token")
    public String getNewAccessToken() {

        return refreshTokenService.refreshToken();
    }

    @GetMapping("/generate-jwt-token")
    public String getJwt() {

        return jwtTokenService.generateToken();
    }
}
