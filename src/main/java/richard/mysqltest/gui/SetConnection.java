package richard.mysqltest.gui;//Generated by GuiGenie - Copyright (c) 2004 Mario Awad.
//Home Page http://guigenie.cjb.net - Check often for new versions!

import java.awt.*;
import javax.swing.*;

public class SetConnection extends JPanel {
    private JButton button1;

    public JButton getJcomp1() {
        return jcomp1;
    }

    private JButton jcomp1;

    public JCheckBox getJcomp2() {
        return jcomp2;
    }

    private JCheckBox jcomp2;
    private JLabel jcomp3;

    public JTextField getHost() {
        return host;
    }

    public JTextField getUser() {
        return user;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JTextField getPort() {
        return port;
    }

    private JTextField host;
    private JTextField user;
    private JPasswordField passwordField;
    private JTextField port;
    private JLabel jcomp8;
    private JLabel jcomp9;
    private JLabel jcomp10;
    private JLabel jcomp11;

    public JButton getButton1() {
        return button1;
    }

    public SetConnection() {
        //construct components
        jcomp1 = new JButton ("Set Connection");
        button1 = new JButton ("File");
        jcomp2 = new JCheckBox ("Save to Config");
        jcomp3 = new JLabel ("Set your Connection to your Database");
        host = new JTextField (5);
        user = new JTextField (5);
        passwordField = new JPasswordField (5);
        port = new JTextField (5);
        jcomp8 = new JLabel ("Hostname");
        jcomp9 = new JLabel ("User");
        jcomp10 = new JLabel ("Password");
        jcomp11 = new JLabel ("Port");

        //adjust size and set layout
        setPreferredSize (new Dimension (290, 289));
        setLayout (null);

        //add components
        add (jcomp1);
        add (jcomp2);
        add (jcomp3);
        add (host);
        add (user);
        add (passwordField);
        add (port);
        add (jcomp8);
        add (jcomp9);
        add (jcomp10);
        add (jcomp11);
        add (button1);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (63, 220, 160, 30);
        button1.setBounds (20, 240, 30, 30);
        jcomp2.setBounds (88, 257, 110, 25);
        jcomp3.setBounds (34, 15, 215, 25);
        host.setBounds (137, 60, 100, 25);
        user.setBounds (137, 100, 100, 25);
        passwordField.setBounds (138, 140, 100, 25);
        port.setBounds (138, 180, 100, 25);
        jcomp8.setBounds (53, 60, 100, 25);
        jcomp9.setBounds (70, 100, 100, 25);
        jcomp10.setBounds (54, 140, 100, 25);
        jcomp11.setBounds (70, 185, 100, 25);
    }
}
