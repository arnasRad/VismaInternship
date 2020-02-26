package com.arnasrad.vismainternship.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;

@Configuration
public class RestClientConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public SimpleDateFormat simpleDateFormat(@Value("${dates.defaultFormat}") String defaultDateFormat) {
        return new SimpleDateFormat(defaultDateFormat);
    }
}
