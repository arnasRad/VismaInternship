package com.arnasrad.vismainternship.component;

import com.arnasrad.vismainternship.revolut.service.RefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class RestTemplateHeaderModifierInterceptor
        implements ClientHttpRequestInterceptor {

    @Value("${authorization.headerName")
    private String headerName;

    @Value("${authorization.headerType")
    private String headerType;

    @Autowired
    RefreshTokenService refreshTokenService;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        ClientHttpResponse response = execution.execute(request, body);
        if (response.getStatusCode() == HttpStatus.UNAUTHORIZED) {
            request.getHeaders().set(headerName, headerType + " " + refreshTokenService.refreshAndGetAccessToken());
            return execution.execute(request, body);
        }
        return response;
    }
}
