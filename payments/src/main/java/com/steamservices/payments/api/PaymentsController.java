package com.steamservices.payments.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentsController {

    @GetMapping("/{userId}/{gameId}")
    String purchaseGame(@PathVariable("userId") long userId, @PathVariable("gameId") long gameId) {
        //check if user has game
        return "userid + gameid megvette!!";
    }
}
