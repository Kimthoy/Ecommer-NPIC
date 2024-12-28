package com.div.ecommerce.ecommerce.service;

import com.div.ecommerce.ecommerce.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    Customer create(Customer customer);
    Customer update(Long id, Customer customer);
    Customer getById(Long id);
    Customer delete(Long id);
    List<Customer >getAll();
}
