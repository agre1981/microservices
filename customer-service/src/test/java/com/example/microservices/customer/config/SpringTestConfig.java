package com.example.microservices.customer.config;

import com.example.microservices.customer.intercomm.AccountClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
public class SpringTestConfig {

    @Bean
    public AccountClient accountClient() {
        return mock(AccountClient.class);
    }
}
