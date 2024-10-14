package com.spring.integration.withoutadapter.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;

@Configuration
@EnableIntegration
public class IntegrationConfiguration {

    @Bean
    public DirectChannel inputChannel(){
        return new DirectChannel();
    }

    @Bean
    public DirectChannel outputChannel(){
        return new DirectChannel();
    }

    @Bean
    public DirectChannel finalChannel(){
        return new DirectChannel();
    }
}
