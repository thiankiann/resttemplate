package com.example.resttemplate.itunes.service;

import com.example.resttemplate.itunes.proxy.ItunesProxy;
import com.example.resttemplate.itunes.proxy.ItunesResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItunesService {

    @Autowired
    ItunesProxy itunesClient;

    @Autowired
    ItunesMapper itunesMapper;

    public void fetchShawnMendesSong() throws JsonProcessingException {
        String json = itunesClient.makeRequest("shawnmendes", 3);
        if (json != null) {
            ItunesResponse shawnMendesResponse = itunesMapper.mapJsonToItunesResponse(json);
            System.out.println(shawnMendesResponse);
        }
    }

}
