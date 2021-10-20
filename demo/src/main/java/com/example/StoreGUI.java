package com.example;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class StoreGUI extends JFrame {

    JMenuBar menuBar;
    JMenu gameMenu, searchMenu, aGame;
    JMenuItem addGame, addDev, addDist, byName, byTags, byDev, byDist, newGames, devs, dist;

    public StoreGUI(Store store) {
        setTitle("SteamCopy");
        menuBar = new JMenuBar();
        gameMenu = new JMenu("Game");
        searchMenu = new JMenu("Search");
        aGame = new JMenu("Game");
        addGame = new JMenuItem("Add new Game");
        addDev = new JMenuItem("add new Developer");
        addDist = new JMenuItem("add new Distributor");
        byName = new JMenuItem("By Name");
        byTags = new JMenuItem("By Tags");
        byDev = new JMenuItem("By Developer");
        byDist = new JMenuItem("By Distributor");
        newGames = new JMenuItem("New Games");
        devs = new JMenuItem("a Developer");
        dist = new JMenuItem("a Distributor");
        addGame.addActionListener(new CreateGameController(store, this));
        gameMenu.add(addGame);
        gameMenu.add(addDev);
        gameMenu.add(addDist);
        aGame.add(byName);
        aGame.add(byTags);
        aGame.add(byDev);
        aGame.add(byDist);
        searchMenu.add(aGame);
        searchMenu.add(newGames);
        searchMenu.add(devs);
        searchMenu.add(dist);
        menuBar.add(gameMenu);
        menuBar.add(searchMenu);

        setJMenuBar(menuBar);
        setSize(1280, 720);
        setLocation(500, 500);
        setResizable(false);
        getContentPane().setBackground(Color.GRAY);

        setVisible(true);
        try {
            this.addWindowListener(new ExitController(store, this));
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        } catch (Exception e) {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            e.printStackTrace();
        }

    }

}
