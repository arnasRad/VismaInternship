package com.arnasrad.vismainternship.persistence.customer;

import com.arnasrad.vismainternship.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
}
