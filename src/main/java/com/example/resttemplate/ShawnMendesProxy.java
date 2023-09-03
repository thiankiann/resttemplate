package com.example.resttemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

// GET https://itunes.apple.com/search?term=shawnmendes&limit=1

@Component
public class ShawnMendesProxy {

    RestTemplate restTemplate;

    public String makeShawnMendesRequest(String term, Integer limit){

    }

}
