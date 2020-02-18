package com.arnasrad.vismainternship.service.revolut.request;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.web.client.RestTemplate;

class RevolutAccountServiceTest {

    @InjectMocks
    private RevolutAccountService revolutAccountService;

    @Mock
    private RestTemplate restTemplate;
/*
    @Test
    void getAccounts_shouldReturnList_whenOK() {

        List<RevolutAccount> testAccounts = getTEstAccounts();

        when(restTemplate.exchange(anyString(), HttpMethod.GET, RevolutAccount.class,)).then(testAccounts);

        List<RevolutAccount> accounts = revolutAccountService.getAccounts();
        assertEquals();
    }

    @Test
    void getAccounts_shouldThrowException_whenOK() {

        List<RevolutAccount> testAccounts = getTEstAccounts();

        when(restTemplate.exchange(anyString(), HttpMethod.GET, RevolutAccount.class,)).then(testAccounts);

        List<RevolutAccount> accounts = revolutAccountService.getAccounts();
        assertEquals();
    }

 */
}