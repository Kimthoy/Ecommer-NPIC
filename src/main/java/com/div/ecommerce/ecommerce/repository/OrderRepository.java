package com.div.ecommerce.ecommerce.repository;

import com.div.ecommerce.ecommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
