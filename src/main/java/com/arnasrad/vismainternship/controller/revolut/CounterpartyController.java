package com.arnasrad.vismainternship.controller.revolut;

import com.arnasrad.vismainternship.model.dto.revolut.counterparty.RevolutCounterpartyDto;
import com.arnasrad.vismainternship.service.revolut.request.RevolutCounterpartyService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CounterpartyController {

    private final RevolutCounterpartyService counterpartyService;

    public CounterpartyController(RevolutCounterpartyService counterpartyService) {
        this.counterpartyService = counterpartyService;
    }

    @PostMapping(value = "/revolut/add-counterparty", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public RevolutCounterpartyDto addCounterparty(@RequestBody String body) {
        return counterpartyService.addCounterparty(body);
    }

    @GetMapping("/revolut/counterparties")
    public List<RevolutCounterpartyDto> getCounterparties() {
        return counterpartyService.getCounterparties();
    }

    @DeleteMapping("/revolut/delete-counterparty")
    public String deleteCounterparty(@RequestParam String id) {
        return counterpartyService.deleteCounterparty(id);
    }
}
