package com.example;

import java.io.Serializable;
import java.util.Map;

public class Distributor implements Serializable {

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((myGames == null) ? 0 : myGames.hashCode());
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
        Distributor other = (Distributor) obj;
        if (myGames == null) {
            if (other.myGames != null)
                return false;
        } else if (!myGames.equals(other.myGames))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}
