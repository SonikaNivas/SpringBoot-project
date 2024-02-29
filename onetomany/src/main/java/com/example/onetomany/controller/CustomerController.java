package com.example.onetomany.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onetomany.model.Customer;
import com.example.onetomany.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController{
    private final CustomerService serv;

    public CustomerController(CustomerService serv) {
        this.serv = serv;
    }

    @PostMapping("/map")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer pro) {
        Customer addedCustomer = serv.addCustomer(pro);
        return new ResponseEntity<>(addedCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/map")
    public ResponseEntity<List<Customer>> getCustomer() {
        List<Customer> customers = serv.getCustomer();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("map/{customerId}")
    public ResponseEntity<Customer> getCustomerbyId(@PathVariable int customerId) {
        Customer project = serv.getCustomerbyId(customerId);
        if (project != null) {
            return new ResponseEntity<>(project, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    

    @GetMapping("/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Customer>> getSortedPagination(@PathVariable("offset") int offset,
            @PathVariable("pagesize") int size, @PathVariable("field") String field) {
        List<Customer> list = serv.getSortedPaginationSignin(offset, size, field);
        if (list.size() == 0) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}