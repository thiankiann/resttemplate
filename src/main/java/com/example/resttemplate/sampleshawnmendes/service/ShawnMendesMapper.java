package com.example.resttemplate.sampleshawnmendes.service;

import com.example.resttemplate.sampleshawnmendes.proxy.SampleServerShawnMendesResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ShawnMendesMapper {
    SampleServerShawnMendesResponse mapJsonToSampleShawnMendesResponse(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, SampleServerShawnMendesResponse.class);
    }
}
