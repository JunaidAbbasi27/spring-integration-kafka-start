package com.spring.integration.withoutadapter.configuration;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;

@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.bootstrap-address}")
    private String servers;

    @Bean
    public KafkaAdmin kafkaAdmin(){
        HashMap<String, Object> config = new HashMap<>();

        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        return new KafkaAdmin(config);
    }

    @Bean
    public NewTopic newTopic(){
        return new NewTopic("first_test", 1, (short) 1);
    }
}