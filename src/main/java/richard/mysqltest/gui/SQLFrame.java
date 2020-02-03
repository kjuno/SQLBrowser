package richard.mysqltest.gui;

import javax.swing.*;

public class SQLFrame extends JFrame {
    JPanel panel = new JPanel();

    public SQLFrame(Object[][] tabledata, String[] columnname) {
        getContentPane().add(panel);
        setSize(600,400);
        setLocationRelativeTo(null); //Setzt Frame in die Mitte
        panel.add(new JScrollPane(new JTable(tabledata,columnname)));
        setVisible(true);
    }

    public void setTable(JTable jTable) {

    }
}
