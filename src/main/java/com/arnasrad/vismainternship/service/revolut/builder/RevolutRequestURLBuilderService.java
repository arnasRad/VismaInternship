package com.arnasrad.vismainternship.service.revolut.builder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class RevolutRequestURLBuilderService {

    private final SimpleDateFormat simpleDateFormat;
    @Value("${revolut.endpoint.transactions}")
    private String transactionsEndpoint;

    public RevolutRequestURLBuilderService(SimpleDateFormat simpleDateFormat) {
        this.simpleDateFormat = simpleDateFormat;
    }

    public String getTransactionsURI(String counterparty, Date from, Date to, Integer count) {

        String fromString = simpleDateFormat.format(from);
        String toString = simpleDateFormat.format(to);

        return UriComponentsBuilder.fromHttpUrl(transactionsEndpoint)
                .queryParam("counterparty", counterparty)
                .queryParam("from", fromString)
                .queryParam("to", toString)
                .queryParam("count", count).toUriString();
    }
}
