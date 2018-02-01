package com.example.microservices.customer.config;

import com.example.microservices.customer.intercomm.AccountClient;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringTestConfig {

    @Bean
    public AccountClient accountClient() {
        return Mockito.mock(AccountClient.class);
    }
}
