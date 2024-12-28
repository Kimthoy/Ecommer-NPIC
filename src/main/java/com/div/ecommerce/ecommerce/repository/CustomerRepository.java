package com.div.ecommerce.ecommerce.repository;

import com.div.ecommerce.ecommerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
