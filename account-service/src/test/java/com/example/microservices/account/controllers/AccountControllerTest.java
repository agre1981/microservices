package com.example.microservices.account.controllers;

import com.example.microservices.account.model.Account;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public class AccountControllerTest extends BaseControllerIT {

    private JacksonTester<Account> accountEntityJacksonTester;
    private JacksonTester<List<Account>> listAccountEntityJacksonTester;

    @Test
    public void testFindByNumber() throws IOException {
        // test
        ResponseEntity<String> response = this.restTemplate.getForEntity("/accounts/111111", String.class);

        // validate
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());

        Account account = accountEntityJacksonTester.parse(response.getBody()).getObject();
        Assert.assertEquals(1, account.getId().intValue());
        Assert.assertEquals("111111", account.getNumber());
        Assert.assertEquals(1, account.getCustomerId().intValue());
    }

    @Test
    public void testFindAll() throws IOException {
        // test
        ResponseEntity<String> response = this.restTemplate.getForEntity("/accounts", String.class);

        // validate
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        List<Account> accounts = listAccountEntityJacksonTester.parse(response.getBody()).getObject();

        Assert.assertTrue(accounts.size() > 0);
    }

    @Test
    public void testCreateAccount() throws IOException {

        Account account = new Account(-1,-1, "123");
        // test
        ResponseEntity<String> response = this.restTemplate.postForEntity("/accounts", account, String.class);

        // validate
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Account accountResponse = accountEntityJacksonTester.parse(response.getBody()).getObject();

        Assert.assertEquals(-1, accountResponse.getCustomerId().intValue());
    }

    @Test
    @Ignore
    public void testCreateAccountValidationIdNull() {

        Account account = new Account(null,111, "123");
        // test
        ResponseEntity<String> response = this.restTemplate.postForEntity("/accounts", account, String.class);

        // validate
        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        String responseBody = response.getBody();

        Assert.assertEquals("", responseBody);
    }
}
