package com.example.microservices.customer.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.example.microservices.customer.intercomm.AccountClient;
import com.example.microservices.customer.model.Account;
import com.example.microservices.customer.model.Customer;
import com.example.microservices.customer.model.CustomerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@Autowired
	private AccountClient accountClient;
	
	protected Logger logger = Logger.getLogger(CustomerController.class.getName());
	
	private List<Customer> customers;
	
	public CustomerController() {
		customers = new ArrayList<>();
		customers.add(new Customer(1, "1111", "David Beckham", CustomerType.INDIVIDUAL));
		customers.add(new Customer(2, "2222", "Cristiano Ronaldo", CustomerType.INDIVIDUAL));
		customers.add(new Customer(3, "3333", "Zinaid Zidane", CustomerType.INDIVIDUAL));
		customers.add(new Customer(4, "4444", "Lionel Messi", CustomerType.INDIVIDUAL));
	}
	
	@GetMapping("/customers")
	public List<Customer> findAll() {
		logger.info("Customer.findAll()");
		return customers;
	}
	
	@GetMapping("/customers/{id}")
	public Customer findById(@PathVariable("id") Integer id) {
		logger.info(String.format("Customer.findById(%s)", id));
		Customer customer = customers.stream().filter(it -> it.getId().intValue() == id.intValue()).findFirst().get();
		List<Account> accounts =  accountClient.getAccounts(id);
		customer.setAccounts(accounts);
		return customer;
	}
	
}
