package Frotend;

import backend.NotCorrectSizeWordException;
import backend.PlayWithUser;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class PlayWithUserGame extends Menu implements ActionListener {

    Image background;
    PlayWithUser playWithUser;
    JTextField giveMeAWord;
    JFrame pUserG;
    JButton checkWord;
    JButton showWord;
    WithWhoToPlay withWhoToPlay;
    JButton back;
    JPanel playUser;
    //JTable
    JTable table;
    DefaultTableModel model;
    JScrollPane scroll;
    String[] headers = {"Your try", "result"};
    String[] data = {"", ""};
    ArrayList<String> ar = new ArrayList<>();


    public void insert() {
        ar.addAll(Arrays.asList(data));

        for (int i = 0; i < (ar.size() / 2); i++) {
            model.addRow(new Object[]{String.valueOf(ar.get(2 * i)),
                    String.valueOf(ar.get((2 * i) + 1))});
        }
    }

    public PlayWithUserGame(WithWhoToPlay whtp) {
        this.withWhoToPlay = whtp;
        this.background = Toolkit.getDefaultToolkit().createImage(".jpg");
        this.giveMeAWord = new JTextField();
        this.checkWord = new JButton("Check your word");
        this.back = new JButton("Back");
        //this.withWhoToPlay = new WithWhoToPlay();
        this.showWord = new JButton("Show me the word");
        this.setLayout(new BorderLayout());
        setBorder(new LineBorder(Color.GREEN, 3));
        table = new JTable();
        scroll = new JScrollPane(table);
        scroll.setSize(300, 300);
        scroll.setBorder(new LineBorder(Color.BLACK, 3));
        this.add(scroll, BorderLayout.CENTER);


    }

    @Override
    public void paintComponent(Graphics g) {
        repaint();
        g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
    }

    public void window() {
        playUser = new JPanel(new GridLayout(3, 3, 5, 10));
        playUser.setBackground(new Color(0, 0, 0, 0));
        playUser.add(giveMeAWord);
        playUser.add(checkWord);
        checkWord.addActionListener(this);
        playUser.add(showWord);
        showWord.addActionListener(this);
        playUser.add(new JLabel());
        playUser.add(new JLabel());
        playUser.add(back);
        back.addActionListener(this);
        playUser.setBorder(new LineBorder(Color.RED, 3));
        add(playUser, BorderLayout.NORTH);

    }


    public void frameWindow() {
        pUserG = new JFrame();
        pUserG.setTitle("5 letters word");
        pUserG.setSize(900, 600);
        pUserG.setVisible(true);
        pUserG.add(this, BorderLayout.CENTER);
        pUserG.setResizable(false);
        pUserG.setLocationRelativeTo(null);
        window();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        playWithUser = new PlayWithUser();
        if (e.getActionCommand().equals("Check your word")) {
            try {
                int check = playWithUser.checkTheWord(withWhoToPlay.getSecretWord(), giveMeAWord.getText());
                data[0] = String.valueOf(check);
                data[1] = giveMeAWord.getText();
                //JTable

                model = new DefaultTableModel();
                model.setColumnIdentifiers(headers);
                insert();
                table.setModel(model);

            } catch (NotCorrectSizeWordException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        if (e.getActionCommand().equals("Back")) {
            pUserG.setVisible(false);
        }
        if (e.getActionCommand().equals("Show me the word")) {
            JOptionPane.showMessageDialog(null, String.valueOf(withWhoToPlay.getSecretWord()));
        }
    }
}
