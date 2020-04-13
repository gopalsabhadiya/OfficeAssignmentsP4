package com.airline.consumer.connector;

import com.airline.consumer.entity.Flight;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.List;

@Service
public class FlightConnector {

    @Value("${airline.ig.flightendpoint}")
    private String igflight;

    String base64Creds = Base64.getEncoder().encodeToString("root:root".getBytes());

    private final RestTemplate restTemplate;

    public FlightConnector(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Flight> getAllFlights(){
        HttpHeaders authHeader = new HttpHeaders();
        authHeader.add("Authorization", "Basic " + base64Creds);

        try {
            URI uriIg = new URI(igflight);
            List<Flight> flightsIg = WebClient.create().get().uri(uriIg).header("Authorization", "Basic "+base64Creds).retrieve().bodyToFlux(Flight.class).collectList().block();
            return flightsIg;
        }catch (URISyntaxException e){
            e.printStackTrace();
        }
        return null;
    }

}
