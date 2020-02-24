package com.arnasrad.vismainternship.service.factory;

import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.service.request.TransferService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferServiceFactory {

    private List<TransferService> transferServiceList;

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
