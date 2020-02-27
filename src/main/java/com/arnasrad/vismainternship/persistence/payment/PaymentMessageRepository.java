package com.arnasrad.vismainternship.persistence.payment;

import com.arnasrad.vismainternship.model.entity.payment.PaymentMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMessageRepository extends JpaRepository<PaymentMessage, Long> {
}
