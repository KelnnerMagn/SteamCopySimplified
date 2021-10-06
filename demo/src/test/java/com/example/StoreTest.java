package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.example.Tag.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreTest {

    Store store;
    Game game;
    Map<String, Game> games;
    Developer dev;
    Distributor dis;
    List<Tag> tags;

    @BeforeEach
    void setUp() {
        this.store = new Store();
        this.games = new HashMap<>();
        this.tags = new ArrayList<>();
        this.dev = new Developer("Nintendo", this.games);
        this.dis = new Distributor("Nintendo", this.games);
        this.tags.add(ARCADE);
        this.tags.add(ADVENTURE);
        this.dev.getDevGames().put("Mario",
                new Game(new GameStatus("Mario", "fun game", this.tags, new BigDecimal("200")), new Companies(dev, dis),
                        LocalDate.now()));
        this.dis.getDistGames().put("Mario",
                new Game(new GameStatus("Mario", "fun game", this.tags, new BigDecimal("200")), new Companies(dev, dis),
                        LocalDate.now()));
        this.game = new Game(new GameStatus("Zelda", "fun game", this.tags, "100"), new Companies(this.dev, this.dis),
                LocalDate.now());
    }

    @Test
    void createGameTest() {
        assertDoesNotThrow(() -> store.createGame(game));
        assertTrue(store.getAllGames().size() == 1);
        assertThrows(ItemAlreadyExistException.class, () -> store.createGame(game));
        assertDoesNotThrow(
                () -> store.createGame(new GameStatus("Mario", "fun game", tags, "200"), new Companies(dev, dis)));
        assertTrue(store.getAllGames().size() == 2);
        assertThrows(ItemAlreadyExistException.class,
                () -> store.createGame(new GameStatus("Mario", "fun game", tags, "200"), new Companies(dev, dis)));
        assertTrue(store.getAllGames().size() == 2);
        assertTrue(store.getAllGames().containsKey("Zelda"));
        assertTrue(store.getAllGames().containsKey("Mario"));

    }

    @Test
    void getGameTest() {
        // assertTrue(store.getAllGames().size() == 1);
        assertThrows(ItemDoesNotExistException.class, () -> store.getGame("Dark"));
        assertDoesNotThrow(() -> store.createGame(game));
        assertDoesNotThrow(() -> store.getGame("Zelda"));

    }

    @Test
    void getGameByTagsTest() {
        assertDoesNotThrow(() -> store.createGame(game));
        List<Tag> list = new ArrayList<>();
        list.add(WAR);
        list.add(FIGHT);
        assertTrue(!store.getGameByTags(tags).isEmpty());
        assertTrue(store.getGameByTags(tags).size() == 1);
        assertTrue(store.getGameByTags(list).isEmpty());
    }

    @Test
    void addDeveloperTest() {
        assertDoesNotThrow(() -> store.addDeveloper(new Developer("Sony", games)));
        assertThrows(ItemAlreadyExistException.class, () -> store.addDeveloper(new Developer("Sony", games)));
        assertDoesNotThrow(() -> store.addDeveloper(dev));
        assertDoesNotThrow(() -> assertTrue(store.addDeveloper(new Developer("da", games))));
    }

    @Test
    void getDeveloperTest() {
        assertDoesNotThrow(() -> store.addDeveloper(dev));
        assertDoesNotThrow(() -> store.getDeveloper(dev.getName()));
        assertThrows(ItemDoesNotExistException.class, () -> store.getDeveloper("Sony"));
    }

    @Test
    void addDistributorTest() {
        assertDoesNotThrow(() -> store.addDistributor(new Distributor("Sony", games)));
        assertThrows(ItemAlreadyExistException.class, () -> store.addDistributor(new Distributor("Sony", games)));
        assertDoesNotThrow(() -> store.addDistributor(dis));
        assertDoesNotThrow(() -> assertTrue(store.addDistributor(new Distributor("da", games))));
    }

    @Test
    void getDistributorTest() {
        assertDoesNotThrow(() -> store.addDistributor(dis));
        assertDoesNotThrow(() -> store.getDistributor(dis.getName()));
        assertThrows(ItemDoesNotExistException.class, () -> store.getDistributor("Sony"));
    }

    @Test
    void getGameByDevTest() {
        assertDoesNotThrow(() -> store.addDeveloper(dev));
        assertDoesNotThrow(
                () -> store.getDeveloper(dev.getName()).getDevGames().put(game.getGameStatus().getName(), game));
        assertDoesNotThrow(() -> assertTrue(store.getGameByDev(dev).containsKey(game.getGameStatus().getName())));
        assertThrows(ItemDoesNotExistException.class, () -> store.getGameByDev(new Developer("Sony", games)));
        assertDoesNotThrow(() -> assertTrue(store.getGameByDev(dev).size() == 2));
    }

    @Test
    void getGameByDistTest() {
        assertDoesNotThrow(() -> store.addDistributor(dis));
        assertDoesNotThrow(
                () -> store.getDistributor(dis.getName()).getDistGames().put(game.getGameStatus().getName(), game));
        assertDoesNotThrow(() -> assertTrue(store.getGameByDist(dis).containsKey(game.getGameStatus().getName())));
        assertThrows(ItemDoesNotExistException.class, () -> store.getGameByDist(new Distributor("Sony", games)));
        assertDoesNotThrow(() -> assertTrue(store.getGameByDist(dis).size() == 2));
    }

}
