package com.spring.integration.withadapter.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

@Configuration
public class MessageChannelConfiguration {

    @Bean
    public MessageChannel kafkaProducerChannel() {
        return new DirectChannel();
    }

    @Bean("kafkaConsumerChannel")
    public MessageChannel kafkaConsumerChannel() {
        return new DirectChannel(); // Messages from Kafka go here
    }

    @Bean
    public MessageChannel kafkaErrorChannel(){
        return new DirectChannel();
    }
}
