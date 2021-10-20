package com.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StoreIO {

    String path = "store.txt";
    Store store;
    Scanner input;
    BufferedWriter output;

    public StoreIO(Store store) throws IOException {
        this.store = store;
        input = new Scanner(path);
        output = new BufferedWriter(new FileWriter(path));
    }

    public void saveData() {

        for (Game g : store.getAllGames().values()) {

            String gStats = g.getGameStatus().getName() + "#" + g.getGameStatus().getDescription() + "#"
                    + g.getGameStatus().getRawPrice() + "#" + g.getGameStatus().getTags();
            String gComp = g.getCompanies().getDeveloper().getName() + "#"
                    + g.getCompanies().getDistributor().getName();
            String res = gStats + "$" + gComp;
            try {
                output.write(res);
                output.newLine();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }

}
