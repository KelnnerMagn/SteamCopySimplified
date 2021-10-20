package com.example;

import java.io.Serializable;
import java.util.Map;

public class Developer implements Serializable {

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((devGames == null) ? 0 : devGames.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Developer other = (Developer) obj;
        if (devGames == null) {
            if (other.devGames != null)
                return false;
        } else if (!devGames.equals(other.devGames))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}
