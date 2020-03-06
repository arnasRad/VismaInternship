package com.arnasrad.vismainternship.mapper.dnb;

import com.arnasrad.vismainternship.model.dto.PaymentAccountReference;
import com.arnasrad.vismainternship.model.dto.PaymentAmount;
import com.arnasrad.vismainternship.model.dto.PaymentDto;
import com.arnasrad.vismainternship.model.dto.PaymentRequestDto;
import com.arnasrad.vismainternship.model.dto.dnb.payment.AccountReference;
import com.arnasrad.vismainternship.model.dto.dnb.payment.Amount;
import com.arnasrad.vismainternship.model.dto.dnb.payment.DnbPaymentDto;
import com.arnasrad.vismainternship.model.dto.dnb.payment.DnbPaymentRequestDto;
import org.springframework.stereotype.Component;

@Component
public class DnbPaymentMapper {

    public PaymentDto mapToPaymentDto(DnbPaymentDto dnbPaymentDto) {
        PaymentDto paymentDto = new PaymentDto();

        paymentDto.setId(dnbPaymentDto.getPaymentId());
        paymentDto.setState(dnbPaymentDto.getTransactionStatus().name());

        return paymentDto;
    }
}
