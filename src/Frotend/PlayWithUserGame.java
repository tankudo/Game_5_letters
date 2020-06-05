package Frotend;

import backend.PlayWithUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayWithUserGame extends Menu implements LayoutManager, ActionListener {

    Image background;
    PlayWithUser playWithUser;
    JTextField giveMeAWord;
    JFrame choseLanguage;
    JButton checkWord;

    public PlayWithUserGame() {
        this.background = Toolkit.getDefaultToolkit().createImage(".jpg");
        this.playWithUser = new PlayWithUser();
        this.giveMeAWord = new JTextField();
        this.checkWord = new JButton("Check your word");

    }

    public void frameWindow() {
        choseLanguage = new JFrame();
        choseLanguage.setTitle("Play with user");
        choseLanguage.setSize(350, 70);
        choseLanguage.setVisible(true);
        choseLanguage.setContentPane(this);
        choseLanguage.setResizable(false);
        choseLanguage.setLocationRelativeTo(null);
        window();
    }

    public void window() {
        JPanel languagePanel = new JPanel(new GridLayout(1, 2, 5, 75));
        languagePanel.setBackground(new Color(0, 0, 0, 0));
        languagePanel.add(giveMeAWord);
        languagePanel.add(checkWord);
        add(languagePanel);
    }

    @Override
    public void paintComponent(Graphics g) {
        repaint();
        g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
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

    }
}
