package com.example.resttemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;


@SpringBootApplication
public class RestTemplateApplication {

    @Autowired
    ShawnMendesProxy shawnMendesClient;

    public static void main(String[] args) {
        SpringApplication.run(RestTemplateApplication.class, args);
    }
    @EventListener(ApplicationStartedEvent.class)
    public void makeRequestToShawnMendesEndpoint() throws JsonProcessingException {
        String json = shawnMendesClient.makeShawnMendesRequest("shawnmendes", 3);
        if(json != null) {
            ShawnMendesResponse shawnMendesResponse = mapJasonToShawnMendesResponse(json);
            System.out.println(shawnMendesResponse);
        }
    }

    private static ShawnMendesResponse mapJasonToShawnMendesResponse(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(json, ShawnMendesResponse.class);
    }

}
