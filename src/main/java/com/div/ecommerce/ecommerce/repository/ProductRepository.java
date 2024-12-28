package com.div.ecommerce.ecommerce.repository;

import com.div.ecommerce.ecommerce.model.Product;
import com.div.ecommerce.ecommerce.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
