package com.steamservices.payments.api;

import com.steamservices.payments.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentsController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/{userId}/{gameId}")
    ResponseEntity<String> purchaseGame(@PathVariable("userId") long userId, @PathVariable("gameId") long gameId) {
        //penz levonasa
        if(!paymentService.sufficientBalance(userId,gameId)){
            return new ResponseEntity<>("Insufficient balance", HttpStatus.BAD_REQUEST);
        }

        //jatek beírás db-be
        paymentService.buyGame(userId, gameId);

        return new ResponseEntity<>("Game is in the library!", HttpStatus.OK);
    }
}
