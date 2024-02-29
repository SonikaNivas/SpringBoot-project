package com.example.onetomany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.onetomany.model.Customer;
import com.example.onetomany.repository.CustomerRepo;

@Service
public class CustomerService {
    @Autowired
    private final CustomerRepo repo;
    
    public CustomerService(CustomerRepo repo) {
        this.repo = repo;
        
    }

    public Customer addCustomer(Customer c) {
        return repo.save(c);
    }

    public List<Customer> getCustomer() {
        return repo.findAll();
    }

    public Customer getCustomerbyId(int customerId) {
        return repo.findById(customerId).orElse(null);
    }

    

    public List<Customer> getSortedPaginationSignin(int offset, int size, String field) {
        return repo.findAll(PageRequest.of(offset, size, Sort.by(field))).getContent();
    }

}