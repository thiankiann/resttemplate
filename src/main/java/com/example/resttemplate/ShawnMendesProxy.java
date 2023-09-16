package com.example.resttemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

// GET https://itunes.apple.com/search?term=shawnmendes&limit=1

@Component
public class ShawnMendesProxy {

    @Autowired
    RestTemplate restTemplate;

    @Value("${adwww}")
    String url;

    public ShawnMendesResponse makeShawnMendesRequest(String term, Integer limit) throws JsonProcessingException {

        String uri = url + "/search?term=" + term + "&limit=" +limit;

        String json = makeRequest(uri);
        return mapJasonToShawnMendesResponse(json);
    }

    private static ShawnMendesResponse mapJasonToShawnMendesResponse(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(json, ShawnMendesResponse.class);
    }

    private String makeRequest(String uri) {
        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    null,
                    String.class
            );
            return response.getBody();
        } catch (RestClientResponseException exception) {
            System.out.println(exception.getMessage());
        } catch (RestClientException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }
}
