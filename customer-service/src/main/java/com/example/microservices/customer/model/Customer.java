package com.example.microservices.customer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@ApiModel(value = "Customer", description = "Customer model")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
