package com.example.microservices.customer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "Customer", description = "Customer model")
public class Customer {

	@ApiModelProperty(value = "Customer id", required = true, readOnly = true, example = "111")
	private Integer id;

	@ApiModelProperty(value = "Customer SSN", required = true, readOnly = true, example = "SSN111")
	private String ssn;

	@ApiModelProperty(value = "Customer name", example = "Customer Agree")
	private String name;

	@ApiModelProperty(value = "Customer type", example = "INDIVIDUAL")
	private CustomerType type;

	@ApiModelProperty(value = "Customer accounts")
	private List<Account> accounts;

	public Customer() {
		
	}
	
	public Customer(Integer id, String ssn, String name, CustomerType type) {
		this.id = id;
		this.ssn = ssn;
		this.name = name;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CustomerType getType() {
		return type;
	}

	public void setType(CustomerType type) {
		this.type = type;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

}
