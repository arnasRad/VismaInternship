package com.arnasrad.vismainternship.persistence.counterparty;

import com.arnasrad.vismainternship.model.counterparty.Counterparty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterpartyRepository extends JpaRepository<Counterparty, String> {
}
