package com.arnasrad.vismainternship.service.dnb.request;

import com.arnasrad.vismainternship.mapper.dnb.DnbPaymentMapper;
import com.arnasrad.vismainternship.model.dto.PaymentDto;
import com.arnasrad.vismainternship.model.dto.PaymentRequestDto;
import com.arnasrad.vismainternship.model.dto.dnb.payment.DnbPaymentDetailsDto;
import com.arnasrad.vismainternship.model.dto.dnb.payment.DnbPaymentDto;
import com.arnasrad.vismainternship.model.dto.dnb.payment.DnbPaymentRequestDto;
import com.arnasrad.vismainternship.model.enums.BankId;
import com.arnasrad.vismainternship.service.dnb.builder.DnbPsd2RequestBuilderService;
import com.arnasrad.vismainternship.service.request.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DnbPaymentService implements PaymentService {

    private final RestTemplate restTemplate;
    private final DnbPsd2RequestBuilderService requestBuilderService;
    private final DnbPaymentMapper dnbPaymentMapper;
    @Value("${dnb.psd2.endpoint.payments}")
    private String paymentsEndpoint;

    public DnbPaymentService(RestTemplate restTemplate, DnbPsd2RequestBuilderService requestBuilderService, DnbPaymentMapper dnbPaymentMapper) {
        this.restTemplate = restTemplate;
        this.requestBuilderService = requestBuilderService;
        this.dnbPaymentMapper = dnbPaymentMapper;
    }

    @Override
    public PaymentDto createPayment(PaymentRequestDto body) {
        DnbPaymentRequestDto dnbPaymentRequestDto = dnbPaymentMapper.mapToDnbPaymentRequestDto(body);

        HttpEntity<DnbPaymentRequestDto> authorizedHttpEntity =
                requestBuilderService.getAuthorizedRequest(dnbPaymentRequestDto);

        String endpointUri = paymentsEndpoint.concat("/").concat(body.getPaymentProduct());

        ResponseEntity<DnbPaymentDto> responseEntity =
                restTemplate.postForEntity(endpointUri, authorizedHttpEntity, DnbPaymentDto.class);

        DnbPaymentDto dnbPaymentDto = responseEntity.getBody();
        return dnbPaymentMapper.mapToPaymentDto(dnbPaymentDto);
    }

    public DnbPaymentDetailsDto getPayment(String paymentProduct, String paymentId) {
        HttpEntity<String> authorizedHttpEntity = requestBuilderService.getAuthorizedRequest();

        String endpointUrl = paymentsEndpoint.concat("/").concat(paymentProduct).concat("/").concat(paymentId);

        ResponseEntity<DnbPaymentDetailsDto> responseEntity = restTemplate.exchange(endpointUrl, HttpMethod.GET,
                authorizedHttpEntity, DnbPaymentDetailsDto.class);

        return responseEntity.getBody();
    }

    @Override
    public String getBankId() {
        return BankId.DNB_ID.getBank();
    }
}
