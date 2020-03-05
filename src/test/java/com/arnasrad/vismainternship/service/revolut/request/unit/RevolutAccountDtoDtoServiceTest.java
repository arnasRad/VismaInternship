package com.arnasrad.vismainternship.service.revolut.request.unit;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RevolutAccountDtoDtoServiceTest {
//
//    private String accountsEndpoint;
//
//    @InjectMocks
//    private RevolutAccountService revolutAccountService;
//
//    @Mock
//    private RestTemplate restTemplate;
//
//    @Mock
//    private RevolutRequestBuilderService revolutRequestBuilderService;
//
//    @Mock
//    private HttpEntity<String> stringHttpEntityMock;
//
//    @Mock
//    private ResponseEntity<String> stringResponseEntityMock;
//
//    @BeforeEach
//    void init() {
//
//        MockitoAnnotations.initMocks(RevolutAccountDtoDtoServiceTest.class);
//        this.accountsEndpoint = "https://sandbox-b2b.revolut.com/api/1.0/accounts";
//        this.revolutAccountService.setAccountsEndpoint(accountsEndpoint);
//    }
//
//    @Test
//    public void whenAllMethodsExecutesOnce_thenGetAccountsReturnsListOfAccounts() {
//
//        String testAccounts = RevolutStringTestData.getAccountsString();
//
//        when(revolutRequestBuilderService.getAuthorizedRequest()).thenReturn(stringHttpEntityMock);
//
//        when(restTemplate.exchange(accountsEndpoint, HttpMethod.GET, stringHttpEntityMock,
//                String.class)).thenReturn(stringResponseEntityMock);
//
//        when(stringResponseEntityMock.getBody()).thenReturn(testAccounts);
//
//        List<RevolutAccountDto> actualAccounts = revolutAccountService.getAccounts();
//
//        verify(revolutRequestBuilderService, times(1)).getAuthorizedRequest();
//        verify(restTemplate, times(1)).exchange(accountsEndpoint, HttpMethod.GET, stringHttpEntityMock,
//                String.class);
//        verify(stringResponseEntityMock, times(1)).getBody();
//
//        assertNotEquals(0, actualAccounts.size());
//    }
//
//    @Test
//    public void whenResponseReturnsAccountListJsonString_thenGetAccountsReturnsListOfAccounts() {
//
//        String testAccounts = RevolutStringTestData.getAccountsString();
//        List<RevolutAccountDto> testAccountList = RevolutObjectTestData.getTestAccounts();
//
//        when(revolutRequestBuilderService.getAuthorizedRequest()).thenReturn(stringHttpEntityMock);
//
//        when(restTemplate.exchange(accountsEndpoint, HttpMethod.GET, stringHttpEntityMock,
//                String.class)).thenReturn(stringResponseEntityMock);
//
//        when(stringResponseEntityMock.getBody()).thenReturn(testAccounts);
//
//        List<RevolutAccountDto> expectedAccounts = new ArrayList<>(testAccountList);
//        List<RevolutAccountDto> actualAccounts = revolutAccountService.getAccounts();
//
//        assertThat(actualAccounts, is(expectedAccounts));
//    }
}