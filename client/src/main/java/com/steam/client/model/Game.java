package com.steam.client.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {

    public long id;

    public String name;

    public double price;

    public String category;
}
