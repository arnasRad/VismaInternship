package com.arnasrad.vismainternship.controller.revolut;

import com.arnasrad.vismainternship.model.revolut.counterparty.AddCounterparty;
import com.arnasrad.vismainternship.model.revolut.counterparty.Counterparty;
import com.arnasrad.vismainternship.model.revolut.requestbody.CounterpartyRequestBody;
import com.arnasrad.vismainternship.service.revolut.RevolutRequestService;
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
    private RevolutRequestService revolutRequestService;

    @PostMapping(value="/revolut/add-counterparty", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public AddCounterparty addCounterparty(@RequestBody CounterpartyRequestBody body) {

        return revolutRequestService.addCounterparty(body);
    }

    @GetMapping("/revolut/counterparties")
    public List<Counterparty> getCounterparties() {

        return revolutRequestService.getCounterparties();
    }
}
