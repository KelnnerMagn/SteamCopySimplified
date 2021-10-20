package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ExitController implements WindowListener {

    StoreIO storeIO;
    Store store;
    JFrame janela;

    public ExitController(Store store, JFrame janela) throws FileNotFoundException, IOException {
        this.storeIO = new StoreIO(store);
        this.store = store;
        this.janela = janela;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            storeIO.saveData();
            janela.setDefaultCloseOperation(janela.EXIT_ON_CLOSE);
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(janela, "we couldn't save the data");
            e1.printStackTrace();
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

}
