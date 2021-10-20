package com.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class storeMain {

    public static void main(String[] args) {
        Store store = new Store();
        try {
            Developer dev = new Developer("Platinium", new HashMap<String, Game>());
            Distributor dis = new Distributor("TypeMoon", new HashMap<String, Game>());
            store.addDeveloper(dev);
            store.addDistributor(dis);
            ArrayList<Tag> tags = new ArrayList<>();
            tags.add(Tag.RPG);
            Game game = new Game(new GameStatus("FateGO", "fun", tags, "5"), new Companies(dev, dis), LocalDate.now());
            store.createGame(game);
            StoreIO storeIO = new StoreIO(store);

            storeIO.saveData();
            // StoreGUI storeNa = new StoreGUI(store);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ItemAlreadyExistException e) {
            e.printStackTrace();
        }

    }
}
