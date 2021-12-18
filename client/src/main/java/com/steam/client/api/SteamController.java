package com.steam.client.api;

import com.steam.client.model.Game;
import com.steam.client.model.SteamUser;
import com.steam.client.service.GameService;
import com.steam.client.service.PurchaseService;
import com.steam.client.service.SteamUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/steam")
public class SteamController {

    @Autowired
    GameService gameService;

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    SteamUserService userService;

    @RequestMapping("/")
    public String home() {
        return "Hello Steam API";
    }

    @GetMapping("/games")
    List<Game> listAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/users")
    List<SteamUser> listAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users/login/{userName}")
    void logIn(@PathVariable("userName") String userName) {
        userService.logIn(userName);
    }

    @GetMapping("/game/{id}")
    Game getGameById(@PathVariable("id") long id) {
        return gameService.getGameById(id);
    }

    @PostMapping("/{userName}/buy/{gameId}")
    ResponseEntity<String> purchaseGame(@PathVariable("userName") String userName, @PathVariable("gameId") long gameId) {
        //user exists
        if(!userService.isUserExists(userName)){
            return new ResponseEntity<>("User not found!", HttpStatus.NOT_FOUND);
        }

        //game exists
        if(!gameService.isGameExists(gameId)){
            return new ResponseEntity<>("Game not found!", HttpStatus.NOT_FOUND);
        }

        //check if logged in
        if(!userService.isLoggedIn(userName)) {
            return new ResponseEntity<>("Not logged in!", HttpStatus.FORBIDDEN);
        }

        //check if user has the game
        if(!purchaseService.isAvailableForPurchase(userName,gameId)) {
            return new ResponseEntity<>("User already owns the game!", HttpStatus.BAD_REQUEST);
        }

        //purchase game
        return purchaseService.purchaseGame(userName,gameId);
    }
}
