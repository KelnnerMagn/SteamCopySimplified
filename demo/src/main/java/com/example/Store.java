package com.example;

import java.util.List;
import java.util.Map;
import java.time.LocalDate;
import java.util.HashMap;

public class Store {

    private Map<String, Game> gamesBD;
    private Map<String, Companies> compBD;

    /**
     * @apiNote Create a new game Store, where the games are tracked by their names
     */
    public Store() {
        this.gamesBD = new HashMap<>();
        this.compBD = new HashMap<>();
    }

    public Map<String, Game> getAllGames() {
        return this.gamesBD;
    }

    public boolean createGame(GameStatus gameStatus, Companies companies) throws ItemAlreadyExistException {
        Game game = new Game(gameStatus, companies, LocalDate.now());
        return createGame(game);
    }

    public boolean createGame(Game game) throws ItemAlreadyExistException {
        if (this.gamesBD.containsKey(game.getGameStatus().getName())) {
            throw new ItemAlreadyExistException(
                    "Already exist a game with this named: " + game.getGameStatus().getName());
        }
        this.gamesBD.put(game.getGameStatus().getName(), game);
        return true;
    }

    public Game getGame(String name) throws ItemDoesNotExistException {
        if (this.gamesBD.containsKey(name)) {
            return gamesBD.get(name);
        }

        throw new ItemDoesNotExistException("The game: " + name + " doesn't Exist");
    }

    public Map<String, Game> getGameByTags(List<Tag> tags) {
        Map<String, Game> tagMatch = new HashMap<>();
        for (Game g : this.gamesBD.values()) {
            if (g.getGameStatus().getTags().equals(tags)) {
                tagMatch.put(g.getGameStatus().getName(), g);
            }
        }
        return tagMatch;
    }

    public Map<String, Game> getGameByDev(Developer dev) throws ItemDoesNotExistException {
        if (!this.compBD.containsKey(dev.getName())) {
            throw new ItemDoesNotExistException("The Developer: " + dev.getName() + " Doesn't exist");
        }

        return this.compBD.get(dev.getName()).getDeveloper().getDevGames();
    }

    public Map<String, Game> getGameByDist(Distributor dis) throws ItemDoesNotExistException {
        if (!this.compBD.containsKey(dis.getName())) {
            throw new ItemDoesNotExistException("The Distributor: " + dis.getName() + "Doesn't exist");
        }

        return this.compBD.get(dis.getName()).getDistributor().getDistGames();
    }

    public Map<String, Game> getJustRealesedGames() {
        Map<String, Game> justRealesedGames = new HashMap<>();
        LocalDate date = LocalDate.now();

        for (Game g : this.gamesBD.values()) {

            if (g.getRealeseDate().plusDays(30).isAfter(date)) {
                justRealesedGames.put(g.getGameStatus().getName(), g);
            }
        }
        return justRealesedGames;
    }

    public boolean addDeveloper(Developer dev) throws ItemAlreadyExistException {
        if (this.compBD.containsKey(dev.getName())) {
            throw new ItemAlreadyExistException("The Developer: " + dev.getName() + " has already been registred");
        }
        this.compBD.put(dev.getName(), new Companies(dev, null));
        return true;
    }

    public Developer getDeveloper(String devName) throws ItemDoesNotExistException {
        if (this.compBD.containsKey(devName)) {
            return this.compBD.get(devName).getDeveloper();
        }
        throw new ItemDoesNotExistException("The Developer: " + devName + " Doesn't exist");
    }

    public Companies getCompanies(String compName) throws ItemDoesNotExistException {
        if (this.compBD.containsKey(compName)) {
            return this.compBD.get(compName);
        }
        throw new ItemDoesNotExistException("the company " + compName + " doesn't exist");
    }

    public boolean addDistributor(Distributor dis) throws ItemAlreadyExistException {
        if (this.compBD.containsKey(dis.getName())) {
            throw new ItemAlreadyExistException("the Distributor: " + dis.getName() + " Already exist");
        }
        this.compBD.put(dis.getName(), new Companies(null, dis));
        return true;
    }

    public Distributor getDistributor(String disName) throws ItemDoesNotExistException {
        if (this.compBD.containsKey(disName)) {
            return this.compBD.get(disName).getDistributor();
        }
        throw new ItemDoesNotExistException("The Distirbutor: " + disName + "Doesn't Exist");
    }
}
