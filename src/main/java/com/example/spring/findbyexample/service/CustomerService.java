package com.example.spring.findbyexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.spring.findbyexample.domain.Customer;
import com.example.spring.findbyexample.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository personRepository;

	public List<Customer> findByExample(Customer probe) {
		return personRepository.findAll(Example.of(probe));
	}

}
