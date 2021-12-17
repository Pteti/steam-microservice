package com.steam.client.service;

import com.steam.client.model.Game;
import com.steam.client.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamingService {

    @Autowired
    GameRepository gameRepository;

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }
}
