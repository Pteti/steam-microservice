package com.steam.client.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PurchaseService {

    private final RestTemplate restTemplate;

    public PurchaseService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ResponseEntity<String> purchaseGame(long userId, long gameId) {
        String url = "http://localhost:9888/" + userId + "/" + gameId;
        ResponseEntity<String> response = this.restTemplate.getForEntity(url, String.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            //baj van
        }
        return response;
    }
}
