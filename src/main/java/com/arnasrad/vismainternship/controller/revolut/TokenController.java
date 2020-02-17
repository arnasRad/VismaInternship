package com.arnasrad.vismainternship.controller.revolut;

import com.arnasrad.vismainternship.service.revolut.RefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    private final RefreshTokenService refreshTokenService;

    @Autowired
    public TokenController(RefreshTokenService refreshTokenService) {

        this.refreshTokenService = refreshTokenService;
    }

    @PostMapping("/revolut/refresh-token")
    public String getNewAccessToken() {

        return refreshTokenService.refreshAndGetAccessToken();
    }
}
