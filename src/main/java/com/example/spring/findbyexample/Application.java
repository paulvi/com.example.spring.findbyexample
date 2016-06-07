package com.example.spring.findbyexample;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;

import com.example.spring.findbyexample.domain.Customer;
import com.example.spring.findbyexample.repository.CustomerRepository;
import com.example.spring.findbyexample.service.CustomerService;


@SpringBootApplication
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CustomerRepository repository, CustomerService customerService) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
			    /*
			     */
				// save a couple of customers
				repository.save(new Customer("Jack", "Bauer"));
				repository.save(new Customer("Chloe", "O'Brian"));
				repository.save(new Customer("Kim", "Bauer"));
				repository.save(new Customer("David", "Palmer"));
				repository.save(new Customer("Michelle", "Dessler"));

				// fetch all customers
				log.info("Customers found with findAll():");
				log.info("-------------------------------");
				for (Customer customer : repository.findAll()) {
					log.info(customer.toString());
				}
			    log.info("");

				// fetch an individual customer by ID
				Customer customerUSA = repository.findOne(1L);
				customerUSA.setCountry("USA");
				repository.save(customerUSA);
				
				/*
				 */
			    Customer c = new Customer();
			    c.setCountry("USA");
			    //http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#query-by-example.execution
			    //Example in spring-data-common v1.12 (Apr 2016) http://mvnrepository.com/artifact/org.springframework.data/spring-data-commons
			    //Example<Person> example = Example.of(person, matcher); 
			    Example<Customer> example = Example.of(c); 
			    List<Customer> list= repository.findAll(example);
			    for (Customer customerByExample : list) {
					log.info(customerByExample.toString());
				}
			    log.info("");
			    
				/*
				 */
			    Customer c2 = new Customer();
			    c2.setCountry("USA");
			    for (Customer customerByExample : customerService.findByExample(c2) ) {
					log.info(customerByExample.toString());
				}
			    log.info("");
			}
		};
	}

}
