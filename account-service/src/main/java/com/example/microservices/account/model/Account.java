package com.example.microservices.account.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Account", description = "Account model")
public class Account {

	@ApiModelProperty(value = "Account id", required = true, readOnly = true, example = "111")
	private Integer id;

	@ApiModelProperty(value = "Account customer id", required = true, example = "222")
	private Integer customerId;

	@ApiModelProperty(value = "Account number", required = true, example = "111111111111111")
	private String number;

	public Account() {

	}

	public Account(Integer id, Integer customerId, String number) {
		this.id = id;
		this.customerId = customerId;
		this.number = number;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
