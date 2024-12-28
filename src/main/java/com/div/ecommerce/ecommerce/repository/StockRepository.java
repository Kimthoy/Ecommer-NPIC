package com.div.ecommerce.ecommerce.repository;

import com.div.ecommerce.ecommerce.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
}
