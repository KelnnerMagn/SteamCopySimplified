package com.example;

import java.time.LocalDate;

public class Game {

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

}