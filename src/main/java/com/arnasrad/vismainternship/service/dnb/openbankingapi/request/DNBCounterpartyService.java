package com.arnasrad.vismainternship.service.dnb.openbankingapi.request;

import com.arnasrad.vismainternship.model.revolut.counterparty.AddCounterparty;
import com.arnasrad.vismainternship.model.revolut.counterparty.Counterparty;
import com.arnasrad.vismainternship.model.revolut.requestbody.CounterpartyRequestBody;
import com.arnasrad.vismainternship.service.ResponseStatusExceptionBuilderService;
import com.arnasrad.vismainternship.service.request.CounterpartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DNBCounterpartyService implements CounterpartyService {

    @Value("${constant.dnb-id-uppercase}")
    private String dnbId;

    private final ResponseStatusExceptionBuilderService exceptionBuilder;

    @Autowired
    public DNBCounterpartyService(ResponseStatusExceptionBuilderService exceptionBuilder) {

        this.exceptionBuilder = exceptionBuilder;
    }

    @Override
    public AddCounterparty addCounterparty(CounterpartyRequestBody body) {

        throw exceptionBuilder.getNoFunctionalityException400(dnbId, "addCounterparty");
    }

    @Override
    public List<Counterparty> getCounterparties() {

        throw exceptionBuilder.getNoFunctionalityException400(dnbId, "getCounterparties");
    }
}
