package com.spring.integration.withoutadapter.controller;

import com.spring.integration.withoutadapter.gateway.MyGateway;
import com.spring.integration.withoutadapter.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class FlowTesting {

    @Autowired
    private MyGateway myGateway;

    @Autowired
    private KafkaService kafkaService;

//    @GetMapping("/{message}")
//    public void sendMessage(@PathVariable String message){
//        myGateway.send(message);
//    }

    @GetMapping("/kafka/{message}")
    public void sendKafkaMessage(@PathVariable String message) throws Exception { kafkaService.sendMessage(message);
    }

    @PostMapping("/kafka/post")
    public void startKafkaProcess(@RequestBody Object obj){
        HashMap<String, String> map = (HashMap<String, String>) obj;
        String topic = map.get("topic");
        String data = map.get("data");
        kafkaService.sendMessage(data, topic);
    }
}
