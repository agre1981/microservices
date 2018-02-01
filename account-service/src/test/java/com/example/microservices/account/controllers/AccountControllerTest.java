package com.example.microservices.account.controllers;

import com.example.microservices.account.model.Account;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;
import java.util.List;

public class AccountControllerTest extends BaseControllerIT {

    private JacksonTester<Account> accountEntityJacksonTester;
    private JacksonTester<List<Account>> listAccountEntityJacksonTester;

    @Test
    public void testFindByNumber() throws IOException {
        // test
        String body = this.restTemplate.getForObject("/accounts/111111", String.class);

        // validate
        Account account = accountEntityJacksonTester.parse(body).getObject();

        Assert.assertEquals(1, account.getId().intValue());
        Assert.assertEquals("111111", account.getNumber());
        Assert.assertEquals(1, account.getCustomerId().intValue());
    }

    @Test
    public void testFindAll() throws IOException {
        // test
        String body = this.restTemplate.getForObject("/accounts", String.class);

        // validate
        List<Account> accounts = listAccountEntityJacksonTester.parse(body).getObject();

        Assert.assertEquals(7, accounts.size());
    }
}
