package com.example.microservices.customer.controllers;

import com.example.microservices.customer.intercomm.AccountClient;
import com.example.microservices.customer.model.Account;
import com.example.microservices.customer.model.Customer;
import com.example.microservices.customer.model.CustomerType;
import com.google.common.collect.Lists;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerControllerTest extends BaseControllerIT {

    private JacksonTester<Customer> accountEntityJacksonTester;
    private JacksonTester<List<Customer>> listAccountEntityJacksonTester;

    @Autowired
    private AccountClient accountClient;

    @After
    public void cleanup() {
        Mockito.reset(accountClient);
    }

    @Test
    public void testFindByNumber() throws IOException {
        // init
        ArrayList<Account> accounts = Lists.newArrayList( new Account(1, "11111") );
        Mockito.when(accountClient.getAccounts(1)).thenReturn(accounts);

        // test
        ResponseEntity<String> response = this.restTemplate.getForEntity("/customers/1", String.class);

        // validate
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());

        Customer customer = accountEntityJacksonTester.parse(response.getBody()).getObject();

        Assert.assertEquals(1, customer.getId().intValue());
        Assert.assertEquals("1111", customer.getSsn());
        Assert.assertEquals("David Beckham", customer.getName());
        Assert.assertEquals(CustomerType.INDIVIDUAL, customer.getType());

        Assert.assertEquals(1, customer.getAccounts().size());
        Assert.assertEquals("11111", customer.getAccounts().get(0).getNumber());
    }

    @Test
    public void testFindAll() throws IOException {
        // test
        ResponseEntity<String> response = this.restTemplate.getForEntity("/customers", String.class);

        // validate
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());

        List<Customer> customers = listAccountEntityJacksonTester.parse(response.getBody()).getObject();
        Assert.assertEquals(4, customers.size());
    }
}
