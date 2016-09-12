package com.techm.whale.controller;



 

import org.springframework.web.client.RestTemplate;
 

import com.techm.whale.model.Family;

 
public class SpringRestTestClient {
 
    public static final String REST_SERVICE_URI = "http://localhost:8080/adms-spring-web";
     
     
    private static void getUser(){
        System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        Family user = restTemplate.getForObject(REST_SERVICE_URI+"/edit/4040    ", Family.class);
        System.out.println(user.getFamilyName());
        System.out.println(user.getFamilyCode());
        System.out.println(user.getFamilyEligibiltyCode());
    }
     
 
    public static void main(String args[]){
        
        getUser();
    }
 
}