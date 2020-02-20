package com.arnasrad.vismainternship.persistence.payment;

import com.arnasrad.vismainternship.model.payment.TransactionLegs;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "transaction-legs", path = "transaction-legs")
public interface TransactionLegsRepository extends PagingAndSortingRepository<TransactionLegs, String> {
}
