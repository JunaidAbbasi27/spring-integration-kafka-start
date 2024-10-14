package com.spring.integration.withoutadapter.service;

import com.spring.integration.withoutadapter.gateway.MyGateway;
import com.spring.integration.withoutadapter.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private MyGateway gateway;

    public void sendMessage(String message) {
        System.out.println("from kafka service send " + message);

        CompletableFuture<SendResult<String, String>> future= kafkaTemplate.send( Constants.SPRING_KAFKA_PRODUCER_TOPIC, message);

        future.whenComplete((result, ex) ->{
            if (ex == null) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        message + "] due to : " + ex.getMessage());

            }
        });
    }

    public void sendMessage(String message, String topic) {
        System.out.println("from kafka service send " + message);

        CompletableFuture<SendResult<String, String>> future= kafkaTemplate.send( topic, message);

        future.whenComplete((result, ex) ->{
            if (ex == null) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        message + "] due to : " + ex.getMessage());

            }
        });

    }

    @KafkaListener(topics = Constants.SPRING_KAFKA_CONSUMER_TOPIC, groupId = "foo")
    public void Listener(String message){
        System.out.println("message received from first_test " + message);
        gateway.send(message);
    }
}
