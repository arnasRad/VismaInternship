package com.arnasrad.vismainternship.persistence.account;

import com.arnasrad.vismainternship.model.account.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetails, String> {
}
