package com.arnasrad.vismainternship.seb.controller;


import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping
public class SebController {

    @GetMapping("/seb/accounts")
    // Throws SSLHandshakeException...
    String getAccounts() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.ob.baltics.sebgroup.com/v2/oauth/authorization/links?bic=EEUHEE2X")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("content-type", "application/json")
                .addHeader("x-request-id", "123")
                .addHeader("date", "Wed, 2 Jan 2019 07:57:24 GMT")
                .build();

        Response response = client.newCall(request).execute();
        return response.toString();
    }
}
