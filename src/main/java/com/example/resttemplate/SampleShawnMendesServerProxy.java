package com.example.resttemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
//GET localhost:8080/shawn/songs
@Component
public class SampleShawnMendesServerProxy {

    @Autowired
    RestTemplate restTemplate;

    @Value("${sample-shawn-mendes-server.service.url}")
    String url;

    @Value("${sample-shawn-mendes-server.service.port}")
    int port;

    public String makeGetRequest() {
        UriComponentsBuilder builder = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host(url)
                .port(port)
                .path("/shawn/songs");
//        HttpHeaders httpHeaders = new HttpHeaders();        //that is just if we need to send headers
//        httpHeaders.add("requestId", "something");
//        HttpEntity<HttpHeaders> httpEntity = new HttpEntity<>(httpHeaders);
        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    builder.build().toUri(),
                    HttpMethod.GET,
                   null,// httpEntity,
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
    public String makePostRequest() {
        UriComponentsBuilder builder = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host(url)
                .port(port)
                .path("/shawn/songs");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("requestId", "something");
        SampleShawnMendesRequest requestBody= new SampleShawnMendesRequest("hahaha");
        HttpEntity<SampleShawnMendesRequest> httpEntity = new HttpEntity<>(requestBody,httpHeaders);

        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    builder.build().toUri(),
                    HttpMethod.POST,
                    httpEntity,
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
    public String makeDeleteRequest(String id) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host(url)
                .port(port)
                .path("/shawn/songs") //" + id );    // path variable version
                .queryParam("id" , id );       // queryParam version

        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    builder.build().toUri(),
                    HttpMethod.DELETE,
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