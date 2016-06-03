package com.example.spring.findbyexample;

import java.util.List;

import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.spring.findbyexample.domain.Customer;
import com.example.spring.findbyexample.repository.CustomerRepository;


@SpringBootApplication
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
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
				Customer customer = repository.findOne(1L);
				log.info("Customer found with findOne(1L):");
				log.info("--------------------------------");
				log.info(customer.toString());
			    log.info("");

//			// fetch customers by last name
//			log.info("Customer found with findByLastName('Bauer'):");
//			log.info("--------------------------------------------");
//			for (Customer bauer : repository.findByLastName("Bauer")) {
//				log.info(bauer.toString());
//			}
//            log.info("");
			    
			    Customer c = new Customer();
			    c.setCountry("USA");
			    
			    //http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#query-by-example.execution
			    //Example<Person> example = Example.of(person, matcher); 
			    Example<Customer> example = Example.of(c); 
			    List<Customer> list= repository.findAll(example);
			}
		};
	}

}
