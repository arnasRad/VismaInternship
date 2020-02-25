package com.arnasrad.vismainternship.persistence.customer;

import com.arnasrad.vismainternship.model.entity.customer.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerInfoRepository extends JpaRepository<CustomerInfo, Long> {
}
