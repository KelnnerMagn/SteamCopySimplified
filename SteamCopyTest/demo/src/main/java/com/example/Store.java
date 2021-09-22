package com.example;

import java.util.List;
import java.util.Map;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;

public class Store {

    private Map<String, Game> gamesBD;
    private Map<String, Developer> devBD;
    private Map<String, Distributor> distBD;

    /**
     * @apiNote Create a new game Store, where the games are tracked by their names
     */
    public Store() {
        this.gamesBD = new HashMap<>();
        this.devBD = new HashMap<>();
        this.distBD = new HashMap<>();
    }

    public Map<String, Game> getAllGames() {
        return this.gamesBD;
    }

    public boolean createGame(String name, String description, List<Tag> tags, Developer developer,
            Distributor distributor, String rawPrice) throws ItemAlreadyExistException {

        if (this.gamesBD.containsKey(name)) {
            throw new ItemAlreadyExistException("Already exist a game with this named: " + name);
        }

        Game game = new Game(name, description, tags, developer, distributor, rawPrice, LocalDate.now());

        if (checkGame(game)) {
            this.gamesBD.put(game.getName(), game);
            return true;
        }
        return false;
    }

    public boolean createGame(String name, String description, List<Tag> tags, Developer developer,
            Distributor distributor, BigDecimal rawPrice) throws ItemAlreadyExistException {
        if (this.gamesBD.containsKey(name)) {
            throw new ItemAlreadyExistException("Already exist a game with this named: " + name);
        }

        Game game = new Game(name, description, tags, developer, distributor, rawPrice, LocalDate.now());

        if (checkGame(game)) {
            this.gamesBD.put(game.getName(), game);
            return true;
        }
        return false;
    }

    public boolean createGame(Game game) throws ItemAlreadyExistException {
        if (this.gamesBD.containsKey(game.getName())) {
            throw new ItemAlreadyExistException("Already exist a game with this named: " + game.getName());
        }

        if (checkGame(game)) {
            this.gamesBD.put(game.getName(), game);
            return true;
        }
        return false;
    }

    public Game getGame(String name) throws ItemDoesNotExistException {
        if (this.gamesBD.containsKey(name)) {
            return gamesBD.get(name);
        }

        throw new ItemDoesNotExistException("The game: " + name + " doesn't Exist");
    }

    public Map<String, Game> getGameByTags(List<Tag> tags) {
        if (tags.isEmpty() || tags == null) {
            return null;
        }

        Map<String, Game> tagMatch = new HashMap<>();
        for (Game g : this.gamesBD.values()) {
            if (g.getTags().equals(tags)) {
                tagMatch.put(g.getName(), g);
            }
        }
        return tagMatch;
    }

    public Map<String, Game> getGameByDev(Developer dev) throws ItemDoesNotExistException {
        if (!this.devBD.containsKey(dev.getName())) {
            throw new ItemDoesNotExistException("The Developer: " + dev.getName() + " Doesn't exist");
        }

        return this.devBD.get(dev.getName()).getDevGames();
    }

    public Map<String, Game> getGameByDist(Distributor dis) throws ItemDoesNotExistException {
        if (!this.distBD.containsKey(dis.getName())) {
            throw new ItemDoesNotExistException("The Distributor: " + dis.getName() + "Doesn't exist");
        }

        return this.distBD.get(dis.getName()).getDistGames();
    }

    public Map<String, Game> getJustRealesedGames() {
        Map<String, Game> justRealesedGames = new HashMap<>();
        LocalDate date = LocalDate.now();

        for (Game g : this.gamesBD.values()) {

            if (g.getRealeseDate().plusDays(30).isAfter(date)) {
                justRealesedGames.put(g.getName(), g);
            }

        }
        return justRealesedGames;
    }

    private boolean checkGame(Game game) {
        if (game.getDescription().isEmpty() || game.getDescription().isBlank() || game.getDescription() == null) {
            return false;
        } else if (game.getTags().isEmpty() || game.getTags().size() < 1 || game.getTags() == null) {
            return false;
        } else if (game.getDeveloper() == null || game.getDistributor() == null) {
            return false;
        } else if (game.getRawPrice().intValue() < 0 || game.getRawPrice() == null) {
            return false;
        } else {
            return isNameOk(game.getName());
        }
    }

    private boolean isNameOk(String name) {

        if (name.length() <= 2) {
            return false;
        } else if (name.isBlank() || name.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean addDeveloper(String name, Map<String, Game> devGames) throws ItemAlreadyExistException {
        if (this.devBD.containsKey(name)) {
            throw new ItemAlreadyExistException("The Developer: " + name + " has already been registred");
        }

        if (isNameOk(name) && devGames != null) {
            this.devBD.put(name, new Developer(name, devGames));
            return true;
        }

        return false;
    }

    public boolean addDeveloper(Developer dev) throws ItemAlreadyExistException {
        if (this.devBD.containsKey(dev.getName())) {
            throw new ItemAlreadyExistException("The Developer: " + dev.getName() + " has already been registred");
        }

        if (isNameOk(dev.getName()) && dev.getDevGames() != null) {
            this.devBD.put(dev.getName(), dev);
            return true;
        }

        return false;
    }

    public Developer getDeveloper(String devName) throws ItemDoesNotExistException {
        if (this.devBD.containsKey(devName)) {
            return this.devBD.get(devName);

        }

        throw new ItemDoesNotExistException("The Developer: " + devName + " Doesn't exist");
    }

    public boolean addDistributor(String name, Map<String, Game> disGames) throws ItemAlreadyExistException {
        if (this.distBD.containsKey(name)) {
            throw new ItemAlreadyExistException("the Distributor: " + name + "Already exist");
        }

        if (isNameOk(name) && disGames != null) {
            this.distBD.put(name, new Distributor(name, disGames));
            return true;
        }
        return false;
    }

    public boolean addDistributor(Distributor dis) throws ItemAlreadyExistException {
        if (this.distBD.containsKey(dis.getName())) {
            throw new ItemAlreadyExistException("the Distributor: " + dis.getName() + " Already exist");
        }

        if (isNameOk(dis.getName()) && dis.getDistGames() != null) {
            this.distBD.put(dis.getName(), dis);
            return true;
        }
        return false;
    }

    public Distributor getDistributor(String disName) throws ItemDoesNotExistException {
        if (this.distBD.containsKey(disName)) {
            return this.distBD.get(disName);

        }

        throw new ItemDoesNotExistException("The Distirbutor: " + disName + "Doesn't Exist");
    }
}
