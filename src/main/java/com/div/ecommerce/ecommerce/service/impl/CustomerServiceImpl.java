package com.div.ecommerce.ecommerce.service.impl;

import com.div.ecommerce.ecommerce.exception.ResourceNotFoundException;
import com.div.ecommerce.ecommerce.model.Customer;
import com.div.ecommerce.ecommerce.repository.CustomerRepository;
import com.div.ecommerce.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Long id, Customer customer) {
        Customer updatedCustomer=getById(id);
        updatedCustomer.setId(customer.getId());
        updatedCustomer.setName(customer.getName());
        updatedCustomer.setGender(customer.getGender());
        updatedCustomer.setPhone(customer.getPhone());
        updatedCustomer.setEmail(customer.getEmail());
        return customerRepository.save(updatedCustomer);
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("ID is not found! with id"+id));
    }

    @Override
    public Customer delete(Long id) {
        Customer deletedCustomer=getById(id);
        customerRepository.delete(deletedCustomer);
        return deletedCustomer;
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
