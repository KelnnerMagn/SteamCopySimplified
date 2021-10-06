package com.example;

import java.util.Map;

public class Developer {

    private String name;
    private Map<String, Game> devGames;

    public Developer(String name, Map<String, Game> devGames) {
        this.name = name;
        this.devGames = devGames;
    }

    public Map<String, Game> getDevGames() {
        return this.devGames;
    }

    public String getName() {
        return this.name;
    }
}
