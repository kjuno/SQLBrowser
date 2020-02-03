package richard.mysqltest.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SQLFrame extends JFrame {
    JPanel panel = new JPanel();

    public SQLFrame(Object[][] tabledata, String[] columnname) {
        setSize(600,400);
        setLocationRelativeTo(null); //Setzt Frame in die Mitte
        getContentPane().add(BorderLayout.CENTER, new JScrollPane(new JTable(tabledata,columnname)));

        JLabel label = new JLabel("Send Statement: ");
        JTextField tf = new JTextField(10); // accepts upto 10 characters
        JButton send = new JButton("Send");

        send.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);

        getContentPane().add(BorderLayout.SOUTH, panel);
        setVisible(true);
    }

    public void setTable(JTable jTable) {

    }
}
