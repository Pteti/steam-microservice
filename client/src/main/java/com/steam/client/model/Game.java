package com.steam.client.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Game {

    @Id
    public long id;

    public String name;

    public double price;

    public String category;
}
