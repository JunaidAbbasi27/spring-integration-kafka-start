package com.spring.integration.withoutadapter.activator;

import com.spring.integration.withoutadapter.service.KafkaService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

@Service
public class MyServiceActivator {

    @Autowired
    private KafkaService kafkaService;

    @ServiceActivator(inputChannel = "finalChannel")
    public void activator(JSONObject message) {
        System.out.println("final Message received is " + message);
        try {
            kafkaService.sendMessage(message.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
