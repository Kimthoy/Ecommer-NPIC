package com.div.ecommerce.ecommerce.service;

import com.div.ecommerce.ecommerce.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    Order create(Order order);
    Order update(Long id, Order order);
    Order getById(Long id);
    Order delete(Long id);
    List<Order>getAll();
}
