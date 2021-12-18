package com.steam.client.service;

import com.steam.client.model.Ownership;
import com.steam.client.repository.OwnershipRepository;
import com.steam.client.repository.SteamUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseService {

    @Autowired
    SteamUserRepository steamUserRepository;

    @Autowired
    OwnershipRepository ownershipRepository;

    private final RestTemplate restTemplate;

    public PurchaseService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ResponseEntity<String> purchaseGame(String userName, long gameId) {
        long userId = steamUserRepository.findByUserName(userName).get(0).getId();
        String url = "http://localhost:9888/" + userId + "/" + gameId;
        ResponseEntity<String> response = this.restTemplate.getForEntity(url, String.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            return new ResponseEntity<>("Failed in payment service", response.getStatusCode());
        }
        return response;
    }

    public boolean isAvailableForPurchase(String userName, long gameId) {
        long userId = steamUserRepository.findByUserName(userName).get(0).getId();
        List<Ownership> ownershipList = ownershipRepository.findBySteamUserId(userId);
        return !(ownershipList.stream().filter(t -> t.gameId == gameId).collect(Collectors.toList()).size() > 0);
    }
}
