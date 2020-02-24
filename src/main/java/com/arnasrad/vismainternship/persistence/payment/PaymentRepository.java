package com.arnasrad.vismainternship.persistence.payment;

import com.arnasrad.vismainternship.model.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {
}
