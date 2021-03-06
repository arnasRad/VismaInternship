package com.arnasrad.vismainternship.service.dnb.request;

import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.model.dto.CounterpartyDto;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.service.request.CounterpartyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DnbCounterpartyService implements CounterpartyService {

    @Override
    public CounterpartyDto addCounterparty(String body) throws NoSuchFunctionalityException {
        throw new NoSuchFunctionalityException(String.format(ErrorMessages.NO_SUCH_FUNCTIONALITY, getBankId(),
                "addCounterparty"));
    }

    @Override
    public List<CounterpartyDto> getCounterparties() throws NoSuchFunctionalityException {
        throw new NoSuchFunctionalityException(String.format(ErrorMessages.NO_SUCH_FUNCTIONALITY, getBankId(),
                "getCounterparties"));
    }

    @Override
    public String deleteCounterparty(String id) throws NoSuchFunctionalityException {
        throw new NoSuchFunctionalityException(String.format(ErrorMessages.NO_SUCH_FUNCTIONALITY, getBankId(),
                "deleteCounterparty"));
    }

    @Override
    public String getBankId() {
        return BankId.DNB_ID.getBank();
    }
}
