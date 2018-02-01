package com.example.microservices.customer.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "eureka.client.enabled")
public class SpringConfig {

}
