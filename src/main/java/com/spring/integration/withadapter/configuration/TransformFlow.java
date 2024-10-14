package com.spring.integration.withadapter.configuration;

import com.spring.integration.util.JsonUtility;
import org.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

@Configuration
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
