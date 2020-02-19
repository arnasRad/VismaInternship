package com.arnasrad.vismainternship.persistence.account;

import com.arnasrad.vismainternship.model.account.AccountDetails;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "account-details", path = "account-details")
public interface AccountDetailsRepository extends PagingAndSortingRepository<AccountDetails, String> {
}
