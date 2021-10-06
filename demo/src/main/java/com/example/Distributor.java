package com.example;

import java.util.Map;

public class Distributor {

    private String name;
    private Map<String, Game> myGames;

    public Distributor(String name, Map<String, Game> myGames) {
        this.name = name;
        this.myGames = myGames;
    }

    public String getName() {
        return this.name;
    }

    public Map<String, Game> getDistGames() {
        return this.myGames;
    }
}
