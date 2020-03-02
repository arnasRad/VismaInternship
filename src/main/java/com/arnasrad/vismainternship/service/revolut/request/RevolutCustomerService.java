package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.model.dto.customer.CustomerDto;
import com.arnasrad.vismainternship.model.dto.customer.CustomerInfoDto;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.service.request.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevolutCustomerService implements CustomerService {

    @Override
    public List<CustomerDto> getCustomers() throws NoSuchFunctionalityException {
        throw new NoSuchFunctionalityException(String.format(ErrorMessages.NO_SUCH_FUNCTIONALITY, getBankId(),
                "getCustomers"));
    }

    @Override
    public CustomerInfoDto getCurrentCustomerInfo() throws NoSuchFunctionalityException {
        throw new NoSuchFunctionalityException(String.format(ErrorMessages.NO_SUCH_FUNCTIONALITY, getBankId(),
                "getCurrentCustomerInfo"));
    }

    @Override
    public CustomerInfoDto getCustomerInfo(String ssn) throws NoSuchFunctionalityException {
        throw new NoSuchFunctionalityException(String.format(ErrorMessages.NO_SUCH_FUNCTIONALITY, getBankId(),
                "getCusomterInfo"));
    }

    @Override
    public String getBankId() {
        return BankId.REVOLUT_ID.getBank();
    }
}
