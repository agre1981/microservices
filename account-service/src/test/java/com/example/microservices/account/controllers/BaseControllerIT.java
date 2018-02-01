package com.example.microservices.account.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class BaseControllerIT {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    protected TestRestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
        JacksonTester.initFields(this, objectMapper);
    }

}
