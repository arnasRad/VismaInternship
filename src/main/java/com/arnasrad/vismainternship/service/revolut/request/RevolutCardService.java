package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.model.Card;
import com.arnasrad.vismainternship.service.ResponseStatusExceptionBuilderService;
import com.arnasrad.vismainternship.service.request.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevolutCardService implements CardService {

    @Value("${constant.revolut-id-uppercase}")
    private String revolutId;

    private final ResponseStatusExceptionBuilderService exceptionBuilder;

    @Autowired
    public RevolutCardService(ResponseStatusExceptionBuilderService exceptionBuilder) {

        this.exceptionBuilder = exceptionBuilder;
    }

    @Override
    public List<Card> getCards() {

        throw exceptionBuilder.getNoFunctionalityException400(revolutId, "getCards");
    }
}
