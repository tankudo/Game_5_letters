package Frotend;

import backend.PlayWithUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithWhoToPlay extends Menu implements LayoutManager, ActionListener {
    Image background;
    JFrame withWhoToPlay;
    JButton you;
    JButton computer;
    PlayWithUser playWithUser;

    public WithWhoToPlay() {
        this.background = Toolkit.getDefaultToolkit().createImage(".jpg");
        this.withWhoToPlay = new JFrame();
        you = new JButton("You");
        this.computer = new JButton("Computer");
        playWithUser = new PlayWithUser();
    }

    @Override
    public void paintComponent(Graphics g) {
        repaint();
        g.drawImage(background, 0, 0, getWidth(), getHeight(), null);

    }

    public void window() {
        JPanel languagePanel = new JPanel(new GridLayout(2, 2, 50, 75));
        languagePanel.setBackground(new Color(0, 0, 0, 0));
        languagePanel.add(new JLabel());
        languagePanel.add(new JLabel("Choose who guess the word"));
        languagePanel.add(you);
        you.addActionListener(this);
        languagePanel.add(computer);
        computer.addActionListener(this);
        add(languagePanel);
    }

    public void frameWindow() {

        withWhoToPlay = new JFrame();
        withWhoToPlay.setTitle("Player choice");
        withWhoToPlay.setSize(750, 450);
        withWhoToPlay.setVisible(true);
        withWhoToPlay.setContentPane(this);
        withWhoToPlay.setResizable(false);
        withWhoToPlay.setLocationRelativeTo(null);
        window();
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
        if (e.getActionCommand().equals("You")) {
            PlayWithUserGame playWithUserGame = new PlayWithUserGame();
            playWithUserGame.frameWindow();
        } else if (e.getActionCommand().equals("Computer")) {

        }
    }
}
