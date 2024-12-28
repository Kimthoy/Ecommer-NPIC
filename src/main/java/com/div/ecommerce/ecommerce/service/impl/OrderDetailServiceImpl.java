package com.div.ecommerce.ecommerce.service.impl;

import com.div.ecommerce.ecommerce.model.Brand;
import com.div.ecommerce.ecommerce.model.Order;
import com.div.ecommerce.ecommerce.model.OrderDetail;
import com.div.ecommerce.ecommerce.model.Product;
import com.div.ecommerce.ecommerce.repository.OrderDetailRepository;
import com.div.ecommerce.ecommerce.repository.OrderRepository;
import com.div.ecommerce.ecommerce.repository.ProductRepository;
import com.div.ecommerce.ecommerce.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private final OrderDetailRepository orderDetailRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository,
                                  OrderRepository orderRepository,
                                  ProductRepository productRepository) {
        this.orderDetailRepository = orderDetailRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    public OrderDetail create(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public OrderDetail update(Long id, OrderDetail orderDetail) {
        OrderDetail updatedOrderDetail=getById(id);
        updatedOrderDetail.setId(orderDetail.getId());

        if (orderDetail.getOrder() != null && orderDetail.getOrder().getId() != null) {
            Order order = orderRepository.findById(orderDetail.getOrder().getId())
                    .orElseThrow(() -> new RuntimeException("Brand not found with id " + orderDetail.getOrder().getId()));
            updatedOrderDetail.setOrder(order);
        }

        if (orderDetail.getProduct() != null && orderDetail.getProduct().getId() != null) {
            Product product = productRepository.findById(orderDetail.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Brand not found with id " + orderDetail.getProduct().getId()));
            updatedOrderDetail.setProduct(product);
        }

        updatedOrderDetail.setQuantity(orderDetail.getQuantity());
        updatedOrderDetail.setPrice(orderDetail.getPrice());
        updatedOrderDetail.setCreateAt(orderDetail.getCreateAt());
        return orderDetailRepository.save(updatedOrderDetail);
    }

    @Override
    public OrderDetail getById(Long id) {
        return orderDetailRepository.findById(id).orElseThrow(()->new RuntimeException("ID not found! We cannot with id ("+id+")"));
    }

    @Override
    public OrderDetail delete(Long id) {
        OrderDetail deleteOrderDetail=getById(id);
        orderDetailRepository.delete(deleteOrderDetail);
        return deleteOrderDetail;
    }

    @Override
    public List<OrderDetail> getAll() {
        return orderDetailRepository.findAll();
    }
}
