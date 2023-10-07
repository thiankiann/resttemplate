package com.example.resttemplate;

import com.example.resttemplate.itunes.service.ItunesService;
import com.example.resttemplate.sampleshawnmendes.service.ShawnMendesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;


@SpringBootApplication
public class RestTemplateApplication {

    @Autowired
    ItunesService itunesService;
    @Autowired
    ShawnMendesService shawnMendesService;



    public static void main(String[] args) {
        SpringApplication.run(RestTemplateApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void run() throws JsonProcessingException {
        itunesService.fetchShawnMendesSong();
        shawnMendesService.testClient();

    }

}
