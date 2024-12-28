package com.div.ecommerce.ecommerce.service.impl;

import com.div.ecommerce.ecommerce.exception.ResourceNotFoundException;
import com.div.ecommerce.ecommerce.model.Brand;
import com.div.ecommerce.ecommerce.model.Customer;
import com.div.ecommerce.ecommerce.model.Order;
import com.div.ecommerce.ecommerce.repository.CustomerRepository;
import com.div.ecommerce.ecommerce.repository.OrderRepository;
import com.div.ecommerce.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public OrderServiceImpl(OrderRepository orderRepository,
                            CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Long id, Order order) {
        Order updatedOrder=getById(id);
        updatedOrder.setId(order.getId());
        if (order.getCustomer() != null && order.getCustomer().getId() != null) {
            Customer customer = customerRepository.findById(order.getCustomer().getId())
                    .orElseThrow(() -> new RuntimeException("Brand not found with id " + order.getCustomer().getId()));
            updatedOrder.setCustomer(customer);
        }
        updatedOrder.setStatus(order.getStatus());
        updatedOrder.setOrderDate(order.getOrderDate());
        updatedOrder.setCreateAt(order.getCreateAt());
        return orderRepository.save(updatedOrder);
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("ID is not found ! we cannot find with id ("+id+")"));
    }

    @Override
    public Order delete(Long id) {
        Order deleteOrder=getById(id);
        orderRepository.delete(deleteOrder);
        return deleteOrder;
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
