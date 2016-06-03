package com.example.spring.findbyexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.findbyexample.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
