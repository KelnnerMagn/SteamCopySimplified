package com.example;

import java.io.Serializable;
import java.time.LocalDate;

public class Game implements Serializable {

    private GameStatus gameStatus;
    private Companies companies;
    private LocalDate realeseDate;

    public Game(GameStatus gameStatus, Companies companies, LocalDate realeseDate) {
        this.gameStatus = gameStatus;
        this.companies = companies;
        this.realeseDate = realeseDate;
    }

    public GameStatus getGameStatus() {
        return this.gameStatus;
    }

    public Companies getCompanies() {
        return this.companies;
    }

    public LocalDate getRealeseDate() {
        return realeseDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((companies == null) ? 0 : companies.hashCode());
        result = prime * result + ((gameStatus == null) ? 0 : gameStatus.hashCode());
        result = prime * result + ((realeseDate == null) ? 0 : realeseDate.hashCode());
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
        Game other = (Game) obj;
        if (companies == null) {
            if (other.companies != null)
                return false;
        } else if (!companies.equals(other.companies))
            return false;
        if (gameStatus == null) {
            if (other.gameStatus != null)
                return false;
        } else if (!gameStatus.equals(other.gameStatus))
            return false;
        if (realeseDate == null) {
            if (other.realeseDate != null)
                return false;
        } else if (!realeseDate.equals(other.realeseDate))
            return false;
        return true;
    }

}