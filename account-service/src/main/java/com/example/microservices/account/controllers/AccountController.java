package com.example.microservices.account.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.example.microservices.account.model.Account;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "AccountController", description = "Account Controller rest service")
public class AccountController {

	private List<Account> accounts;
	
	protected Logger logger = Logger.getLogger(AccountController.class.getName());
	
	public AccountController() {
		accounts = new ArrayList<>();
		accounts.add(new Account(1, 1, "111111"));
		accounts.add(new Account(2, 2, "222222"));
		accounts.add(new Account(3, 3, "333333"));
		accounts.add(new Account(4, 4, "444444"));
		accounts.add(new Account(5, 1, "555555"));
		accounts.add(new Account(6, 2, "666666"));
		accounts.add(new Account(7, 2, "777777"));
	}
	
	@GetMapping(value = "/accounts/{number}")
	@ApiOperation(value = "Find account by number", notes = "Find account by number", response = Account.class)
	@ApiResponses( {
			@ApiResponse( code = 404, message = "Account with such number doesn't exist" )
	} )
	public Account findByNumber(@PathVariable("number") String number) {
		logger.info(String.format("Account.findByNumber(%s)", number));
		return accounts.stream().filter(it -> it.getNumber().equals(number)).findFirst().get();
	}

	@GetMapping(value = "/accounts/customer/{customer}")
	@ApiOperation(value = "Find account by customer", notes = "Find account by customer", response = Account.class)
	@ApiResponses( {
			@ApiResponse( code = 404, message = "Account with such customer doesn't exist" )
	} )
	public List<Account> findByCustomer(@PathVariable("customer") Integer customerId) {
		logger.info(String.format("Account.findByCustomer(%s)", customerId));
		return accounts.stream().filter(it -> it.getCustomerId().equals(customerId)).collect(Collectors.toList());
	}

	@GetMapping(value = "/accounts")
	@ApiOperation(value = "List all accounts", notes = "List all accounts using paging", response = Account.class, responseContainer = "List")
	public List<Account> findAll() {
		logger.info("Account.findAll()");
		return accounts;
	}
	
}
