package com.example.resttemplate.itunes.service;

import com.example.resttemplate.itunes.proxy.ItunesResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ItunesMapper {
    public ItunesResponse mapJsonToItunesResponse(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, ItunesResponse.class);
    }
}
