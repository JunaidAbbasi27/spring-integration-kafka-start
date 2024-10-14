//package com.spring.integration.filter;
//
//import org.springframework.integration.annotation.Filter;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MyFilter {
//
//    @Filter(inputChannel = "outputChannel", outputChannel = "finalChannel")
//    public boolean filterMessage(String message){
//        System.out.println("in filter message received "+ message);
//        return message.contains("HELLO");
//    }
//}
