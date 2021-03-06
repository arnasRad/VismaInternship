package com.arnasrad.vismainternship.service.dnb.request;

import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.service.request.TransferService;
import org.springframework.stereotype.Service;

@Service
public class DnbTransferService implements TransferService {

    @Override
    public String createTransfer(String body) throws NoSuchFunctionalityException {
        throw new NoSuchFunctionalityException(String.format(ErrorMessages.NO_SUCH_FUNCTIONALITY, getBankId(),
                "createTransfer"));
    }

    @Override
    public String getBankId() {
        return BankId.DNB_ID.getBank();
    }
}
