package com.arnasrad.vismainternship.controller.revolut;

import com.arnasrad.vismainternship.model.exception.BadRequestException;
import com.arnasrad.vismainternship.model.revolut.counterparty.RevolutCounterparty;
import com.arnasrad.vismainternship.model.revolut.requestbody.CounterpartyRequestBody;
import com.arnasrad.vismainternship.service.revolut.request.RevolutCounterpartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CounterpartyController {

    private final RevolutCounterpartyService counterpartyService;

    @Autowired
    public CounterpartyController(RevolutCounterpartyService counterpartyService) {

        this.counterpartyService = counterpartyService;
    }

    @PostMapping(value = "/revolut/add-counterparty", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public RevolutCounterparty addCounterparty(@RequestBody CounterpartyRequestBody body) throws BadRequestException {

            return counterpartyService.addCounterparty(body);
    }

    @GetMapping("/revolut/counterparties")
    public List<RevolutCounterparty> getCounterparties() throws BadRequestException {

        return counterpartyService.getCounterparties();
    }
}
