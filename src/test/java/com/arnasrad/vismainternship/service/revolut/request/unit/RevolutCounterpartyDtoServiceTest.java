package com.arnasrad.vismainternship.service.revolut.request.unit;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class RevolutCounterpartyDtoServiceTest {
//    private String counterpartyEndpoint;
//    private String counterpartiesEndpoint;
//
//    @InjectMocks
//    private RevolutCounterpartyService revolutCounterpartyService;
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
//        MockitoAnnotations.initMocks(RevolutCounterpartyDtoServiceTest.class);
//        this.counterpartyEndpoint = "https://sandbox-b2b.revolut.com/api/1.0/counterparty";
//        this.counterpartiesEndpoint = "https://sandbox-b2b.revolut.com/api/1.0/counterparties";
//        this.revolutCounterpartyService.setCounterpartyEndpoint(counterpartyEndpoint);
//        this.revolutCounterpartyService.setCounterpartiesEndpoint(counterpartiesEndpoint);
//    }
//
//    @Test
//    public void whenAllMethodsExecutesOnce_thenGetCounterpartiesReturnsListOfCounterparties() {
//        String testCounterpartiesString = RevolutStringTestData.getCounterpartyListString();
//
//        when(restTemplate.exchange(counterpartiesEndpoint, HttpMethod.GET, stringHttpEntityMock,
//                String.class)).thenReturn(stringResponseEntityMock);
//
//        when(stringResponseEntityMock.getBody()).thenReturn(testCounterpartiesString);
//
//        List<RevolutCounterpartyDto> actualCounterparties = revolutCounterpartyService.getCounterparties();
//
//        verify(restTemplate, times(1)).exchange(counterpartiesEndpoint, HttpMethod.GET, stringHttpEntityMock,
//                String.class);
//        verify(stringResponseEntityMock, times(1)).getBody();
//
//        assertNotEquals(0, actualCounterparties.size());
//    }
//
//    @Test
//    public void whenResponseReturnsCounterpartyListJsonString_thenGetCounterpartiesReturnsListOfCounterparties() {
//        String testCounterpartiesString = RevolutStringTestData.getCounterpartyListString();
//        List<RevolutCounterpartyDto> testCounterpartyList = RevolutObjectTestData.getTestCounterpartyList();
//
//        when(restTemplate.exchange(counterpartiesEndpoint, HttpMethod.GET, stringHttpEntityMock,
//                String.class)).thenReturn(stringResponseEntityMock);
//
//        when(stringResponseEntityMock.getBody()).thenReturn(testCounterpartiesString);
//
//        List<RevolutCounterpartyDto> expectedCounterparties = new ArrayList<>(testCounterpartyList);
//        List<RevolutCounterpartyDto> actualCounterparties = revolutCounterpartyService.getCounterparties();
//
//        assertThat(actualCounterparties, is(expectedCounterparties));
//    }
//
//    @Test
//    public void whenResponseReturnsCounterparty_thenAddCounterpartyReturnsAddedCounterparty() {
////        String testCounterpartyString = RevolutStringTestData.getCounterpartyString();
////        RevolutCounterparty testCounterparty = RevolutObjectTestData.getTestCounterparty();
////
////        when(revolutRequestBuilderService.getAuthorizedJsonRequestWithBody(requestBody)).thenReturn(stringHttpEntityMock);
////
////        when(restTemplate.postForEntity(counterpartyEndpoint, stringHttpEntityMock, String.class)).thenReturn(stringResponseEntityMock);
////
////        when(stringResponseEntityMock.getBody()).thenReturn(testCounterpartyString);
////
////        RevolutCounterparty actualCounterparty = revolutCounterpartyService.addCounterparty(requestBody);
////
////        assertThat(actualCounterparty, is(testCounterparty));
//    }
}