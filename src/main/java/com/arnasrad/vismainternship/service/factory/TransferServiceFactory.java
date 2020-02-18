package com.arnasrad.vismainternship.service.factory;

import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.service.request.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransferServiceFactory {

    private List<TransferService> transferServiceList;

    @Autowired
    public TransferServiceFactory(List<TransferService> transferServiceList) {
        this.transferServiceList = transferServiceList;
    }

    public TransferService getService(String bank) {

        return transferServiceList.stream()
                .filter(transferService -> transferService.getBankId().equals(bank))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(ErrorMessages.WRONG_BANK));
    }
}
