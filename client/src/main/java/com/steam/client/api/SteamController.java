package com.steam.client.api;

import com.steam.client.model.Game;
import com.steam.client.service.GameService;
import com.steam.client.service.GamingService;
import com.steam.client.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/steam")
public class SteamController {

    @Autowired
    GameService gameService;

    @Autowired
    GamingService gamingService;

    @Autowired
    PurchaseService purchaseService;

    @RequestMapping("/")
    public String home() {
        return "Hello Steam API";
    }

    @GetMapping("/games")
    List<Game> listAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/game/{id}")
    Game getGameById(@PathVariable("id") long id) {
        return gameService.getGameById(id);
    }

    @PostMapping("/{userId}/buy/{gameId}")
    ResponseEntity<String> purchaseGame(@PathVariable("userId") long userId, @PathVariable("gameId") long gameId) {
        //check if user has game
        return purchaseService.purchaseGame(userId,gameId);
    }

    @PostMapping("/{userId}/play/{gameId}")
    void playGame(@PathVariable("userId") long userId, @PathVariable("gameId") long gameId) {
        //check if user has game
        //playService.playGame(gameId);
    }
}
