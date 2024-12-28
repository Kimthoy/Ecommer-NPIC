package com.div.ecommerce.ecommerce.controller;

import com.div.ecommerce.ecommerce.dto.CustomerDTO;
import com.div.ecommerce.ecommerce.mapper.CustomerMapper;
import com.div.ecommerce.ecommerce.model.Customer;
import com.div.ecommerce.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping
    private ResponseEntity<?>saveCustomer(@RequestBody CustomerDTO customerDTO){
        Customer savedCustomer= CustomerMapper.INSTANCE.toCustomerEntity(customerDTO);
        savedCustomer=customerService.create(savedCustomer);
        return ResponseEntity.ok(CustomerMapper.INSTANCE.toCustomerDTOEntity(savedCustomer));
    }
    @PutMapping("{id}")
    private ResponseEntity<?>updateCustomer(@PathVariable Long id,@RequestBody CustomerDTO customerDTO){
        Customer updatedCustomer=CustomerMapper.INSTANCE.toCustomerEntity(customerDTO);
        updatedCustomer=customerService.update(id,updatedCustomer);
        return ResponseEntity.ok(CustomerMapper.INSTANCE.toCustomerDTOEntity(updatedCustomer));
    }
    @GetMapping("{id}")
    private ResponseEntity<?>getById(@PathVariable Long id){
        return ResponseEntity.ok( customerService.getById(id));
    }
    @GetMapping("/")
    private ResponseEntity<?>getAll(){
        return ResponseEntity.ok(customerService.getAll());
    }
    @DeleteMapping("{id}")
    private ResponseEntity<?> deleteCustomer(@PathVariable Long id){
        Customer deletedCustomer=customerService.delete(id);
        return ResponseEntity.ok(deletedCustomer);
    }


}
