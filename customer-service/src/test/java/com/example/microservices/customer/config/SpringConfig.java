package com.example.microservices.customer.config;

import com.example.microservices.customer.intercomm.AccountClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
public class SpringConfig {

    @Bean
    public AccountClient accountClient() {
        return mock(AccountClient.class);
    }
}
