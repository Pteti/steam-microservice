package com.steamservices.payments.repository;

import com.steamservices.payments.model.Ownership;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class OwnershipRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWithQuery(Ownership ownership) {
        entityManager.createNativeQuery("INSERT INTO ownership (steam_user_id, game_id) VALUES (?,?)")
                .setParameter(1, ownership.getSteamUserId())
                .setParameter(2, ownership.getGameId())
                .executeUpdate();
    }
}
