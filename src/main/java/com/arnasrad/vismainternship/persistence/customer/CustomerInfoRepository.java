package com.arnasrad.vismainternship.persistence.customer;

import com.arnasrad.vismainternship.model.customer.CustomerInfo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "customer-info", path = "customer-info")
public interface CustomerInfoRepository extends PagingAndSortingRepository<CustomerInfo, String> {
}
