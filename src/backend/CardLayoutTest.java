package backend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CardLayoutTest extends JFrame implements ActionListener {
    JPanel cardPanel = new JPanel();

    JButton first = new JButton("First");
    JButton last = new JButton("Last");
    JButton next = new JButton("Next");
    JButton prev = new JButton("Prev");
    JButton show = new JButton("Show");

    public CardLayoutTest() {
        cardPanel.setLayout(new CardLayout(10, 10));

        for (int k = 0; k < 12; k++) {
            cardPanel.add("" + k, new JLabel("" + k, JLabel.CENTER));
        }

        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttons.add(first);
        first.addActionListener(this);
        buttons.add(last);
        last.addActionListener(this);
        buttons.add(next);
        next.addActionListener(this);
        buttons.add(prev);
        prev.addActionListener(this);
        buttons.add(show);
        show.addActionListener(this);

        add("Center", cardPanel);
        add("South", buttons);

        setBounds(100, 100, 400, 300);
    }

    public static void main(String[] args) {
        CardLayoutTest flt = new CardLayoutTest();
        flt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flt.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == first) {
            ((CardLayout) cardPanel.getLayout()).first(cardPanel);
        }
        if (e.getSource() == last) {
            ((CardLayout) cardPanel.getLayout()).last(cardPanel);
        }
        if (e.getSource() == next) {
            ((CardLayout) cardPanel.getLayout()).next(cardPanel);
        }
        if (e.getSource() == prev) {
            ((CardLayout) cardPanel.getLayout()).previous(cardPanel);
        }
        if (e.getSource() == show) {
            String answer = JOptionPane.showInputDialog("Input number: 0-11");
            if (answer != null) {
                ((CardLayout) cardPanel.getLayout()).show(cardPanel, answer);
            }
        }
    }

}
