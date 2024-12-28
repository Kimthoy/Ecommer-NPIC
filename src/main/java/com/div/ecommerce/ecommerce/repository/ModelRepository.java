package com.div.ecommerce.ecommerce.repository;

import com.div.ecommerce.ecommerce.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Long> {
}
