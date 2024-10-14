package com.spring.integration.withoutadapter.transform;

import com.spring.integration.util.JsonUtility;
import org.json.JSONObject;
import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Service;

@Service
public class MyTransformer {

    @Transformer(inputChannel = "inputChannel", outputChannel = "finalChannel")
    public JSONObject transform(String message){
        System.out.println("in transformer message received "+ message);
        return JsonUtility.XMLToJson(message);
    }
}
