package com.arnasrad.vismainternship.interbankingapi.service;

import com.arnasrad.vismainternship.interbankingapi.model.Account;
import com.arnasrad.vismainternship.revolut.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RequestMappingService {

    @Autowired
    @Qualifier("revolut-request-service")
    private RequestService requestService;

    @Autowired
    ModelConverterService modelConverterService;

    public Map<String, List<Account>> mapAccountsRequest(String bank) {

        Map<String, List<Account>> accounts = new HashMap<>();
        switch (bank) {
            case "revolut":
                accounts.put("revolut",
                        modelConverterService.convertFromRevolutAccountList(requestService.getAccounts()));
                return accounts;
            case "dnb":
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "DNB has no Account functionality");
            default:
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wrong bank specified");
        }
    }
}
