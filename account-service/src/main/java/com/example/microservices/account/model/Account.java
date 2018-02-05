package com.example.microservices.account.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "Account", description = "Account model")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

	@ApiModelProperty(value = "Account id", required = true, readOnly = true, example = "111")
	private Integer id;

	@ApiModelProperty(value = "Account customer id", required = true, example = "222")
	private Integer customerId;

	@ApiModelProperty(value = "Account number", required = true, example = "111111111111111")
	private String number;

}
