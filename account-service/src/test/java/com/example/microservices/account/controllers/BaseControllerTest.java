package com.example.microservices.account.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public abstract class BaseControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    protected MockMvc mockMvc;

    protected void initController(Object controller) {
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .build();

        JacksonTester.initFields(this, objectMapper);
    }


}
