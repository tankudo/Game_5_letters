package Frotend;

import backend.PlayWithUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class WithWhoToPlay extends Menu implements ActionListener {
    Image background;
    JFrame withWhoToPlay;
    JButton you;
    JButton computer;
    JButton back;
    PlayWithUser playWithUser;
    char [] secretWord;

    public WithWhoToPlay() {
        this.background = Toolkit.getDefaultToolkit().createImage(".jpg");
        this.withWhoToPlay = new JFrame();
        this.you = new JButton("You");
        this.computer = new JButton("Computer");
        this.playWithUser = new PlayWithUser();
        this.back = new JButton("Back");
        this.secretWord = new char[5];
    }

    @Override
    public void paintComponent(Graphics g) {
        repaint();
        g.drawImage(background, 0, 0, getWidth(), getHeight(), null);

    }

    public void window() {
        JPanel languagePanel = new JPanel(new GridLayout(3, 2, 20, 30));
        languagePanel.setBackground(new Color(0, 0, 0, 0));
        languagePanel.add(new JLabel());
        languagePanel.add(new JLabel("Choose who guess the word"));
        languagePanel.add(new JLabel());

        languagePanel.add(you);
        you.addActionListener(this);
        languagePanel.add(computer);
        computer.addActionListener(this);
        languagePanel.add(new JLabel());
        languagePanel.add(new JLabel());
        languagePanel.add(new JLabel());
        languagePanel.add(back);
        back.addActionListener(this);
        add(languagePanel);
    }

    public void frameWindow() {

        withWhoToPlay = new JFrame();
        withWhoToPlay.setTitle("Player choice");
        withWhoToPlay.setSize(750, 250);
        withWhoToPlay.setVisible(true);
        withWhoToPlay.setContentPane(this);
        withWhoToPlay.setResizable(false);
        withWhoToPlay.setLocationRelativeTo(null);
        window();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("You")) {
            PlayWithUserGame playWithUserGame = new PlayWithUserGame(this);
            playWithUserGame.frameWindow();
            try {
               secretWord = playWithUser.guessTheWord();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        } else if (e.getActionCommand().equals("Computer")) {

        }
        else if (e.getActionCommand().equals("Back")){
            withWhoToPlay.setVisible(false);
        }
    }

    public char[] getSecretWord() {
        return secretWord;
    }
}
