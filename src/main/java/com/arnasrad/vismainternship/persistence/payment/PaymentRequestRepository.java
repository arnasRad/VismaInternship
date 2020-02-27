package com.arnasrad.vismainternship.persistence.payment;

import com.arnasrad.vismainternship.model.entity.payment.PaymentRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRequestRepository extends JpaRepository<PaymentRequest, String> {
}
