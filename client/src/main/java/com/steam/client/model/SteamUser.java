package com.steam.client.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class SteamUser {
    @Id
    public long id;

    @Column(unique = true,name = "user_name")
    public String userName;

    public Boolean isLoggedIn;
}
