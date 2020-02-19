package com.arnasrad.vismainternship.persistence.counterparty;

import com.arnasrad.vismainternship.model.counterparty.Counterparty;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "counterparty", path = "counterparty")
public interface CounterpartyRepository extends PagingAndSortingRepository<Counterparty, String> {
}
