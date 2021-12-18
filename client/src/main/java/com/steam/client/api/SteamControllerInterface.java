package com.steam.client.api;

import com.steam.client.model.Game;
import com.steam.client.model.SteamUser;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SteamControllerInterface {

    @ApiOperation(value = "The welcome message",
            nickname = "home",
            response = String.class,
            responseContainer = "String")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Welcome!",
                    response = String.class, responseContainer = "String")
    })
    String home();

    @ApiOperation(value = "List all games",
            nickname = "list games",
            response = List.class,
            responseContainer = "List<Game>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Listing all games",
                    response = List.class, responseContainer = "List<Game>")
    })
    List<Game> listAllGames();

    @ApiOperation(value = "List all users",
            nickname = "list users",
            response = List.class,
            responseContainer = "List<SteamUser>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Listing all users",
                    response = List.class, responseContainer = "List<Users>")
    })
    List<SteamUser> listAllUsers();

    @ApiOperation(value = "Log In",
            nickname = "login")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Logged in successfully")
    })
    void logIn(@ApiParam(value = "The user to log in", required = true)
               @PathVariable(required = true) String userName);

    @ApiOperation(value = "Get a Game by Id",
            nickname = "Get game",
            response = Game.class,
            responseContainer = "Game")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get a Game by Id",
                    response = Game.class, responseContainer = "Game")
    })
    Game getGameById(@ApiParam(value = "The game ID", required = true)
                     @PathVariable(required = true) long id);

    @ApiOperation(value = "Purchase a Game for given user",
            nickname = "purchase game",
            response = ResponseEntity.class,
            responseContainer = "ResponseEntity<String>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Purchased game",
                    response = ResponseEntity.class, responseContainer = "ResponseEntity<String>"),
            @ApiResponse(code = 403, message = "User not logged in",
                    response = ResponseEntity.class, responseContainer = "ResponseEntity<String>"),
            @ApiResponse(code = 404, message = "User not found",
                    response = ResponseEntity.class, responseContainer = "ResponseEntity<String>"),
            @ApiResponse(code = 404, message = "Game not found",
                    response = ResponseEntity.class, responseContainer = "ResponseEntity<String>"),
            @ApiResponse(code = 400, message = "User owns the game",
                    response = ResponseEntity.class, responseContainer = "ResponseEntity<String>")
    })
    ResponseEntity<String> purchaseGame(@ApiParam(value = "The user ID", required = true)
                                        @PathVariable(required = true) String userName,
                                        @ApiParam(value = "The game ID", required = true)
                                        @PathVariable(required = true) long gameId);
}
