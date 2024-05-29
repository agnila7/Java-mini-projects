package com.agnila.customer.dal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.agnila.customer.dal.entity.Customer;
import com.agnila.customer.dal.repo.CustomerRepository;

@SpringBootTest
class CustomerdalApplicationTests {
	
	@Autowired
	private CustomerRepository repo;

	@Test
	void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setName("Chapal");
		customer.setProduct("Card");
		customer.setPrice(5d);
		repo.save(customer); // to perform CRUD op , inject Customer repo with @autowired
	}
	
	@Test
	void findByCustomerId() {
		Customer customer= repo.findById(1l).get();
		System.out.println(customer);
	}
	
	@Test
	void updateCustomer() {
		Customer customer= repo.findById(2l).get();
		customer.setName("Agnila");
		customer.setProduct("Lipbalm");
		repo.save(customer);
	}
	
	@Test
	void deleteCustomer() {
//		Customer customer= repo.findById(2l).get();
		repo.deleteById(2l);
	}
}
