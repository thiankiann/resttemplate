package com.example.resttemplate.sampleshawnmendes.service;

import com.example.resttemplate.sampleshawnmendes.proxy.SampleServerShawnMendesResponse;
import com.example.resttemplate.sampleshawnmendes.proxy.SampleShawnMendesServerProxy;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShawnMendesService {

    @Autowired
    SampleShawnMendesServerProxy sampleShawnMendesServerClient;

    @Autowired
    ShawnMendesMapper shawnMendesMapper;

    public void testClient() throws JsonProcessingException {
        String postJsonSampleShawnMendesServer = sampleShawnMendesServerClient.makePostRequest();
        if (postJsonSampleShawnMendesServer != null) {
            SampleServerShawnMendesResponse sampleShawnMendesResponse = shawnMendesMapper.mapJsonToSampleShawnMendesResponse(postJsonSampleShawnMendesServer);
            System.out.println(sampleShawnMendesResponse);
        }
        String getJsonSampleShawnMendesServer = sampleShawnMendesServerClient.makeGetRequest();
        sampleShawnMendesServerClient.makeDeleteRequest("0");
        String getJsonSampleShawnMendesServer2 = sampleShawnMendesServerClient.makeGetRequest();
        if (getJsonSampleShawnMendesServer != null) {
            SampleServerShawnMendesResponse sampleShawnMendesResponse = shawnMendesMapper.mapJsonToSampleShawnMendesResponse(getJsonSampleShawnMendesServer);
            System.out.println(sampleShawnMendesResponse);
        }
        if (getJsonSampleShawnMendesServer2 != null) {
            SampleServerShawnMendesResponse sampleShawnMendesResponse = shawnMendesMapper.mapJsonToSampleShawnMendesResponse(getJsonSampleShawnMendesServer2);
            System.out.println(sampleShawnMendesResponse);
        }
    }

}
