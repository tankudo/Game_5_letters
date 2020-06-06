package Frotend;

import backend.NotCorrectSizeWordException;
import backend.PlayWithUser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PlayWithUserGame extends Menu implements LayoutManager, ActionListener {

    Image background;
    PlayWithUser playWithUser;
    JTextField giveMeAWord;
    JFrame pUserG;
    JButton checkWord;
    WithWhoToPlay withWhoToPlay;
    JButton back;
    //JTable
    JTable table;
    DefaultTableModel model = new DefaultTableModel();
    JScrollPane scroll;
    String headers[] = {"Your try", "result"};
    String[] data = {"", ""};
    ArrayList<String> ar;

    public void insert() {
        for (int i = 0; i < data.length; i++) {
            ar.add(data[i]);
        }

        for (int i = 0; i < (ar.size() / 2); i++) {
            model.addRow(new Object[]{String.valueOf(ar.get(2 * i)),
                    String.valueOf(ar.get((2 * i) + 1))});
        }
    }

    public PlayWithUserGame() {
        this.background = Toolkit.getDefaultToolkit().createImage(".jpg");
        this.giveMeAWord = new JTextField();
        this.checkWord = new JButton("Check your word");
        this.back = new JButton("Back");
        this.withWhoToPlay = new WithWhoToPlay();


    }

    @Override
    public void paintComponent(Graphics g) {
        repaint();
        g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
    }

    public void window() {
        JPanel playUser = new JPanel(new GridLayout(3, 3, 5, 20));
        playUser.setBackground(new Color(0, 0, 0, 0));
        playUser.add(giveMeAWord);
        playUser.add(checkWord);
        checkWord.addActionListener(this);
        playUser.add(new JLabel());
        playUser.add(new JLabel());
        playUser.add(new JLabel());
        playUser.add(back);
        back.addActionListener(this);
        add(playUser);
    }


    public void frameWindow() {
        pUserG = new JFrame();
        pUserG.setTitle("5 letters word");
        pUserG.setSize(450, 270);
        pUserG.setVisible(true);
        pUserG.setContentPane(this);
        pUserG.setResizable(false);
        pUserG.setLocationRelativeTo(null);
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
        playWithUser = new PlayWithUser();
        if (e.getActionCommand().equals("Check your word")) {
            try {
                int check = playWithUser.checkTheWord(withWhoToPlay.getSecretWord(), giveMeAWord.getText());
                data[0] = String.valueOf(check);
                data[1] = giveMeAWord.getText();
                //JTable
                table = new JTable();
                model.setColumnIdentifiers(headers);
                table.setModel(model);
                scroll = new JScrollPane(table);
                ar = new ArrayList<>();

                add(scroll, BorderLayout.NORTH);
                setSize(300, 300);
                setVisible(true);

//                String[][] data = new String[2][2];
//                data[0][0] = giveMeAWord.getText();
//                data[0][1] = Integer.toString(check);
//                data[1][0] = null;
//                data[1][1] = null;
//
//                // Column Names
//                String[] columnNames = {"Your try", "result"};
//
//                // Initializing the JTable
//                JFrame f = new JFrame();
//                JTable j = new JTable(data, columnNames);
//                j.setBounds(30, 40, 200, 300);
//                f.setSize(500, 200);
//                f.setLocationRelativeTo(null);
//
//                JScrollPane sp = new JScrollPane(j);
//                f.add(sp);
//                f.setVisible(true);
                insert();
            } catch (NotCorrectSizeWordException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        if (e.getActionCommand().equals("Back")) {
            pUserG.setVisible(false);
        }
    }
}
