package com.arnasrad.vismainternship.persistence.transaction;

import com.arnasrad.vismainternship.model.entity.transaction.TransactionLegs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionLegsRepository extends JpaRepository<TransactionLegs, Long> {
}
