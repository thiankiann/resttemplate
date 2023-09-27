package com.example.resttemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

// GET https://itunes.apple.com/search?term=shawnmendes&limit=1

@Component
public class ItunesProxy {

    @Autowired
    RestTemplate restTemplate;

    @Value("${itunes.service.url}")
    String url;

    @Value("${itunes.service.port}")
    int port;

    public String makeRequest(String term, Integer limit) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .newInstance()
                .scheme("https")
                .host(url)
                .port(port)
                .path("/search")
                .queryParam("term", term)
                .queryParam("limit", limit);
        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    builder.build().toUri(),
                    HttpMethod.GET,
                    null,
                    String.class
            );
            return response.getBody();
        } catch (RestClientResponseException exception) {
            System.out.println(exception.getStatusText() + " " + exception.getStatusCode().value());
        } catch (RestClientException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

}