package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.example.Tag.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CreateGameController implements ActionListener {

    Store store;
    JFrame janela;

    public CreateGameController(Store store, JFrame janela) {
        this.store = store;
        this.janela = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = JOptionPane.showInputDialog(janela, "What is the name of the game?  ");
        String description = JOptionPane.showInputDialog(janela, "Tell us more about your game: ");

        Tag[] tags = { ACTION, ADVENTURE, FIGHT, HORROR, SCI_FI, PUZZLE, SURVIVAL, INDIE, METROVANIA, MISTERY, CO_OP,
                WAR, HACK_AND_SLASH, RPG, ARCADE };
        JOptionPane.showMessageDialog(janela, "Choose at least 1 tag");
        ArrayList<Integer> list = new ArrayList<>();
        int next = JOptionPane.OK_OPTION;
        while (next == JOptionPane.OK_OPTION) {
            int a = JOptionPane.showOptionDialog(janela, "Choose relateble tags", "Tags", JOptionPane.OK_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, tags, RPG);
            if (list.contains(a)) {
                JOptionPane.showMessageDialog(janela, "You already choose this one, please the another one");
            } else {
                list.add(a);
                next = JOptionPane.showConfirmDialog(janela, "Want to choose more ?");
            }

        }
        ArrayList<Tag> relatedTags = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            relatedTags.add(tags[list.get(i)]);
        }
        boolean ok = false;
        String rawPrice = "0";
        while (!ok) {
            try {
                rawPrice = JOptionPane.showInputDialog(janela, "What is the price of your game ?");
                Double.parseDouble(rawPrice);
                ok = true;
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(janela, "Please input a real price");
            }
        }

        Developer dev = null;
        Distributor dis = null;
        boolean pass = false;
        while (!pass) {
            try {
                String devName = JOptionPane.showInputDialog(janela, "Whats in the name of the developer? ");
                String disName = JOptionPane.showInputDialog(janela, "Whats in the name of the distributor? ");
                dev = store.getDeveloper(devName);
                dis = store.getDistributor(disName);
                pass = true;
            } catch (ItemDoesNotExistException i) {
                JOptionPane.showMessageDialog(janela, "please check if the Developer exist");
            }

        }
        GameStatus gameStatus = new GameStatus(name, description, relatedTags, rawPrice);
        Companies companies = new Companies(dev, dis);
        try {
            store.createGame(gameStatus, companies);
            JOptionPane.showMessageDialog(janela, "The game has been created succefully");
        } catch (ItemAlreadyExistException e1) {
            JOptionPane.showMessageDialog(janela, "the game you're adding already exist");
            e1.printStackTrace();
        }
    }

}
