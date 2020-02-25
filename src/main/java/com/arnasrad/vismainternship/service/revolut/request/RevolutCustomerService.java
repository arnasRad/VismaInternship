package com.arnasrad.vismainternship.service.revolut.request;

import com.arnasrad.vismainternship.model.ErrorMessages;
import com.arnasrad.vismainternship.model.entity.customer.Customer;
import com.arnasrad.vismainternship.model.entity.customer.CustomerInfo;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.model.exception.NoSuchFunctionalityException;
import com.arnasrad.vismainternship.service.request.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevolutCustomerService implements CustomerService {

    @Override
    public List<Customer> getCustomers() throws NoSuchFunctionalityException {
        throw new NoSuchFunctionalityException(String.format(ErrorMessages.NO_SUCH_FUNCTIONALITY, getBankId(),
                "getCustomers"));
    }

    @Override
    public CustomerInfo getCurrentCustomerInfo() throws NoSuchFunctionalityException {
        throw new NoSuchFunctionalityException(String.format(ErrorMessages.NO_SUCH_FUNCTIONALITY, getBankId(),
                "getCurrentCustomerInfo"));
    }

    @Override
    public CustomerInfo getCustomerInfo(String ssn) throws NoSuchFunctionalityException {
        throw new NoSuchFunctionalityException(String.format(ErrorMessages.NO_SUCH_FUNCTIONALITY, getBankId(),
                "getCusomterInfo"));
    }

    @Override
    public String getBankId() {
        return BankId.REVOLUT_ID.getBank();
    }
}
