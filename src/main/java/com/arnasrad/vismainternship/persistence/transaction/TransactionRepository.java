package com.arnasrad.vismainternship.persistence.transaction;

import com.arnasrad.vismainternship.model.entity.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
