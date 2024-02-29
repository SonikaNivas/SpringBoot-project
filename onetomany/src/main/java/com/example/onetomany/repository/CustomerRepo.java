package com.example.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onetomany.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}