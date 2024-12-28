package com.div.ecommerce.ecommerce.service;

import com.div.ecommerce.ecommerce.model.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDetailService {
    OrderDetail create(OrderDetail orderDetail);
    OrderDetail update(Long id,OrderDetail orderDetail);
    OrderDetail getById(Long id);
    OrderDetail delete(Long id);
    List<OrderDetail>getAll();
}
