package com.arnasrad.vismainternship.revolut.controller;

import com.arnasrad.vismainternship.revolut.model.counterparty.AddCounterparty;
import com.arnasrad.vismainternship.revolut.model.counterparty.Counterparty;
import com.arnasrad.vismainternship.revolut.model.requestbody.CounterpartyRequestBody;
import com.arnasrad.vismainternship.revolut.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CounterpartyController {

    @Autowired
    @Qualifier("revolut-request-service")
    private RequestService requestService;

    @PostMapping(value="/revolut/add-counterparty", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public AddCounterparty addCounterparty(@RequestBody CounterpartyRequestBody body) {

        return requestService.addCounterparty(body);
    }

    @GetMapping("/revolut/counterparties")
    public List<Counterparty> getCounterparties() {

        return requestService.getCounterparties();
    }
}
