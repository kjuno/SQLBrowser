package richard.mysqltest.gui;

import javax.swing.*;

public class SQLFrame extends JFrame {
    JPanel panel = new JPanel();
    public SQLFrame(){
        getContentPane().add(panel);
        setSize(400,400);
        setLocationRelativeTo(null); //Setzt Frame in die Mitte
        setVisible(true);
    }
}
