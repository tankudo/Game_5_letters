package Frotend;

import backend.ArtificialIntelligence;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ChooseYourLanguage extends Menu implements LayoutManager, ActionListener {
    Image gameBackground;
    JFrame choseLanguage;
    JButton english;
    JButton russian;
    JButton hungarian;
    JTextField welcome;
    ArtificialIntelligence ai;

    public ChooseYourLanguage() {
        this.gameBackground = Toolkit.getDefaultToolkit().createImage("5words.jpg");
        this.choseLanguage = new JFrame();
        this.english = new JButton("English");
        this.russian = new JButton("Russian");
        this.hungarian = new JButton("Hungarian");
        this.welcome = new JTextField(13);
        ai = new ArtificialIntelligence();
    }

    public void frameWindow() {
        choseLanguage = new JFrame();
        choseLanguage.setTitle("Start the game");
        choseLanguage.setSize(950, 450);
        choseLanguage.setVisible(true);
        choseLanguage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        choseLanguage.setContentPane(this);
        choseLanguage.setResizable(false);
        choseLanguage.setLocationRelativeTo(null);
        window();
    }

    public void window() {
        JPanel languagePanel = new JPanel(new GridLayout(3, 3, 5, 75));
        languagePanel.setBackground(new Color(0.1f, 0.1f, 0.1f, 0.1f));
        languagePanel.add(new JLabel());
        languagePanel.add(new JLabel("Welcome to 5 letter word game"));
        languagePanel.add(new JLabel());
        languagePanel.add(new JLabel());
        languagePanel.add(new JLabel("Word from which language to play with?"));
        languagePanel.add(new JLabel());
        languagePanel.add(english);
        english.addActionListener(this);
        languagePanel.add(russian);
        russian.addActionListener(this);
        languagePanel.add(hungarian);
        hungarian.addActionListener(this);
        add(languagePanel);
    }


    @Override
    public void paintComponent(Graphics g) {
        repaint();
        g.drawImage(gameBackground, 0, 0, getWidth(), getHeight(), null);
    }

    @Override
    public void addLayoutComponent(String name, Component comp) {

    }

    @Override
    public void removeLayoutComponent(Component comp) {

    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return null;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return null;
    }

    @Override
    public void layoutContainer(Container parent) {


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("English")) {
            String filepath = "en.txt";
            WithWhoToPlay withWhoToPlay = new WithWhoToPlay();
            withWhoToPlay.frameWindow();
            try {
                ArrayList<String> en = ai.readTheFile(filepath);
                System.out.println(en.size());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        } else if (e.getActionCommand().equals("Russian")) {
            String filepath = "ru.txt";
            WithWhoToPlay withWhoToPlay = new WithWhoToPlay();
            withWhoToPlay.frameWindow();
            try {
                ArrayList<String> re = ai.readTheFile(filepath);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        } else if (e.getActionCommand().equals("Hungarian")) {
            String filepath = "hu.txt";
            WithWhoToPlay withWhoToPlay = new WithWhoToPlay();
            withWhoToPlay.frameWindow();
            try {
                ArrayList<String> hu = ai.readTheFile(filepath);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}