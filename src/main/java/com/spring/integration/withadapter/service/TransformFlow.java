package com.spring.integration.withadapter.service;

import com.spring.integration.util.JsonUtility;
import org.json.JSONObject;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

@Service
public class TransformFlow {

    @Transformer(inputChannel = "kafkaConsumerChannel", outputChannel = "kafkaProducerChannel")
    public Message<?> xmlToJsonTransformer(Message<?> message) {
        String xml = (String) message.getPayload();
        System.out.println("Consumed xml string is " + xml);
        JSONObject json = JsonUtility.XMLToJson(xml);
        System.out.println("transformed json string is " + json.toString());
        return new GenericMessage<>(json.toString());
    }
}
