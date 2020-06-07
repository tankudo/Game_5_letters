package backend;

import javax.swing.*;

class NullLayoutTest extends JFrame {
    public NullLayoutTest() {
        getContentPane().setLayout(null);
        for (int k = 0; k < 12; k++) {
            JButton tmp = new JButton("" + k);
            tmp.setBounds(10, k * 30, 50, 25);
            getContentPane().add(tmp);
        }

        setBounds(100, 100, 400, 300);
    }

    public static void main(String[] args) {
        NullLayoutTest flt = new NullLayoutTest();
        flt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flt.setVisible(true);
    }
}
