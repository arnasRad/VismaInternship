package com.arnasrad.vismainternship.persistence.account;

import com.arnasrad.vismainternship.model.account.Account;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "accounts", path = "accounts")
public interface AccountRepository extends PagingAndSortingRepository<Account, String> {

    List<Account> findByName(@Param("name") String name);

    Optional<Account> findById(@Param("id") String id);
}
