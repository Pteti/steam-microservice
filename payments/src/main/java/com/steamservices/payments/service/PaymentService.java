package com.steamservices.payments.service;

import com.steamservices.payments.model.Game;
import com.steamservices.payments.model.Ownership;
import com.steamservices.payments.model.SteamUser;
import com.steamservices.payments.repository.GameRepository;
import com.steamservices.payments.repository.OwnershipRepository;
import com.steamservices.payments.repository.SteamUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    SteamUserRepository steamUserRepository;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    OwnershipRepository ownershipRepository;

    public boolean sufficientBalance(long userId, long gameId) {
        SteamUser user = steamUserRepository.findById(userId).get();
        Game game = gameRepository.findById(gameId).get();

        return user.balance >= game.price;
    }

    public void buyGame(long userId, long gameId) {
        SteamUser user = steamUserRepository.findById(userId).get();
        Game game = gameRepository.findById(gameId).get();

        user.balance = user.balance - game.price;
        steamUserRepository.save(user);

        Ownership newOwnership = new Ownership(userId, gameId);

        ownershipRepository.insertWithQuery(newOwnership);
    }
}
