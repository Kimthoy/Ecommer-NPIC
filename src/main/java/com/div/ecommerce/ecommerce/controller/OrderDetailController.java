package com.div.ecommerce.ecommerce.controller;

import com.div.ecommerce.ecommerce.dto.OrderDetailDTO;
import com.div.ecommerce.ecommerce.mapper.OrderDetailMapper;
import com.div.ecommerce.ecommerce.model.OrderDetail;
import com.div.ecommerce.ecommerce.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orderDetails")
public class OrderDetailController {
    @Autowired
    private final OrderDetailService orderDetailService;

    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }
    @PostMapping
    private ResponseEntity<?>save(@RequestBody OrderDetailDTO orderDetailDTO){
        OrderDetail savedOrderDetail= OrderDetailMapper.INSTANCE.toOrderDetailEntity(orderDetailDTO);
       savedOrderDetail= orderDetailService.create(savedOrderDetail);
       return ResponseEntity.ok(OrderDetailMapper.INSTANCE.toOrderDetailDTOEntity(savedOrderDetail));
    }
    @PutMapping("{id}")
    private ResponseEntity<?>update(@PathVariable Long id,@RequestBody OrderDetailDTO orderDetailDTO){
        OrderDetail updatedOrderDetail=OrderDetailMapper.INSTANCE.toOrderDetailEntity(orderDetailDTO);
        updatedOrderDetail=orderDetailService.update(id,updatedOrderDetail);
        return ResponseEntity.ok(OrderDetailMapper.INSTANCE.toOrderDetailDTOEntity(updatedOrderDetail));
    }
    @GetMapping("{id}")
    private ResponseEntity<?>getById(@PathVariable Long id){
        return ResponseEntity.ok(orderDetailService.getById(id));
    }
    @GetMapping("/")
    private ResponseEntity<?>getAll(){
        return ResponseEntity.ok(orderDetailService.getAll());
    }
    @DeleteMapping("{id}")
    private ResponseEntity<?>delete(@PathVariable Long id){
        return ResponseEntity.ok(orderDetailService.delete(id));
    }
}
