package com.div.ecommerce.ecommerce.controller;

import com.div.ecommerce.ecommerce.dto.OrderDTO;
import com.div.ecommerce.ecommerce.mapper.OrderMapper;
import com.div.ecommerce.ecommerce.model.Order;
import com.div.ecommerce.ecommerce.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")

public class OrderController {
    @Autowired
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping
    private ResponseEntity<?>savedOrder(@RequestBody OrderDTO orderDTO){
        Order savedOrder= OrderMapper.INSTANCE.toOrderEntity(orderDTO);
        savedOrder=orderService.create(savedOrder);
        return ResponseEntity.ok(OrderMapper.INSTANCE.toOrderDTOEntity(savedOrder));
    }
    @PutMapping("{id}")
    private ResponseEntity<?>updateOrder(@PathVariable Long id,@RequestBody OrderDTO orderDTO){
        Order updatedOrder=OrderMapper.INSTANCE.toOrderEntity(orderDTO);
        updatedOrder=orderService.update(id,updatedOrder);
        return ResponseEntity.ok(OrderMapper.INSTANCE.toOrderDTOEntity(updatedOrder));
    }
    @GetMapping("{id}")
    private ResponseEntity<?>getById(@PathVariable Long id){
        return ResponseEntity.ok(orderService.getById(id));
    }
    @GetMapping("/")
    private ResponseEntity<?>getAll(){
        return ResponseEntity.ok(orderService.getAll());
    }
    @DeleteMapping("{id}")
    private Order deleteOrder(@PathVariable Long id){
        return orderService.delete(id);
    }


}
