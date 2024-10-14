package com.spring.integration.util;

import org.json.JSONObject;
import org.json.XML;

public class JsonUtility {

    public static JSONObject XMLToJson(String xmlData){
        return XML.toJSONObject(xmlData);
    }

    public static String JsonToXML(JSONObject object){
        return XML.toString(object);
    }
}
