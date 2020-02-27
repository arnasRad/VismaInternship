package com.arnasrad.vismainternship.service.revolut.builder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class RevolutRequestURLBuilderService {

    private final SimpleDateFormat simpleDateFormat;
    @Value("${revolut.endpoint.transactions}")
    private String transactionsEndpoint;

    public RevolutRequestURLBuilderService(SimpleDateFormat simpleDateFormat) {
        this.simpleDateFormat = simpleDateFormat;
    }

    public String getTransactionsURI(String counterparty, Date from, Date to, Integer count) {

        Optional<String> fromString = Optional.ofNullable(from).map(simpleDateFormat::format);
        Optional<String> toString = Optional.ofNullable(to).map(simpleDateFormat::format);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(transactionsEndpoint);

        Optional.ofNullable(counterparty).ifPresent(c -> builder.queryParam("counterparty", c));
        fromString.ifPresent(date -> builder.queryParam("from", date));
        toString.ifPresent(date -> builder.queryParam("to", date));
        Optional.ofNullable(count).ifPresent(c -> builder.queryParam("count", String.valueOf(c)));

        return builder.toUriString();
    }
}
