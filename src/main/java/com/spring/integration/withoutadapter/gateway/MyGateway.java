package com.spring.integration.withoutadapter.gateway;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

@Component
@MessagingGateway(defaultRequestChannel = "inputChannel")
public interface MyGateway {
    void send(String message);
}
