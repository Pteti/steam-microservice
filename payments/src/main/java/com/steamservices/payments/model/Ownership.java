package com.steamservices.payments.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Ownership {
    @Id
    private long id;

    public long steamUserId;
    public long gameId;


    public Ownership(long steamUserId, long gameId) {
        this.steamUserId = steamUserId;
        this.gameId = gameId;
    }
}
