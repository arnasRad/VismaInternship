package com.arnasrad.vismainternship.persistence.payment;

import com.arnasrad.vismainternship.model.payment.Payment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "payments", path = "payments")
public interface PaymentRepository extends PagingAndSortingRepository<Payment, String> {
}
