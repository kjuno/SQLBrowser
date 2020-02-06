package richard.mysqltest.gui;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import richard.mysqltest.main.Main;
import richard.mysqltest.mysql.commands.SQLCommand;
import richard.mysqltest.mysql.data.ConnectionData;
import richard.mysqltest.mysql.data.JSONExport;
import richard.mysqltest.mysql.data.Table;
import richard.mysqltest.mysql.handler.GetTableOutput;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class SQLFrame extends JFrame {
    private JMenuItem setconnection;
    private JMenu connectionmenu;
    private JCheckBox check;
    private JPanel panel = new JPanel();
    private SetConnection connectionpanel = new SetConnection();
    private JButton send;
    private JLabel label;
    private JTextField tf;
    private JTable view;
    private JMenuBar bar;
    private JMenu tools;
    private JMenuItem jsontable;
    private JMenuItem jsonstatement;
    private JDialog frame;


    public SQLFrame() {
        setSize(600,400);
        setTitle("SQL Browser");
        setLocationRelativeTo(null); //Setzt Frame in die Mitte

        view = new JTable() {
            public boolean isCellEditable(int nRow, int nCol) {
                return false;
            }
        };

        bar = new JMenuBar();
        Border bo = new LineBorder(Color.DARK_GRAY);
        bar.setBorder(bo);

        tools = new JMenu("Tools");
        bar.add(tools);

        jsonstatement = new JMenuItem("generate JSON from statement");
        jsontable = new JMenuItem("generate JSON from table_content");

        jsonstatement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GetTableOutput returnHandler = new GetTableOutput();
                Main.getManager().writeStatement(new SQLCommand(tf.getText(), returnHandler));
                String json = JSONExport.convertTabletoJSON(new Table(returnHandler.getColumnname(), returnHandler.getTabledata()));
                System.out.println(json);
            }
        });

        jsontable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] columnname = new String[view.getColumnCount()];
                Object[][] tabledata = new Object[view.getRowCount()][view.getColumnCount()];
                for (int i = 0; i < view.getColumnCount(); i++) {
                    columnname[i] = view.getColumnName(i);
                    for (int j = 0; j < view.getRowCount(); j++) {
                        tabledata[j][i] = view.getValueAt(j,i);
                    }
                }
                String json = JSONExport.convertTabletoJSON(new Table(columnname, tabledata));
                System.out.println(json);
            }
        });

        tools.add(jsonstatement);
        tools.add(jsontable);

        connectionmenu = new JMenu("Connection");
        setconnection = new JMenuItem("set Connection");
        setconnection.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
            }
        });
        connectionmenu.add(setconnection);
        bar.add(connectionmenu);

        getContentPane().add(BorderLayout.NORTH, bar);
        getContentPane().add(BorderLayout.CENTER, new JScrollPane(view));
        getContentPane().add(BorderLayout.SOUTH, panel);

        label = new JLabel("Send Statement: ");
        tf = new JTextField(20);
        send = new JButton("Send");
        check = new JCheckBox("Return?");

        send.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JButton) {
                    if(check.isSelected()){
                        GetTableOutput returnHandler = new GetTableOutput();
                        Main.getManager().writeStatement(new SQLCommand(tf.getText(), returnHandler));
                        String[] columnname = returnHandler.getColumnname();
                        Object[][] tabledatas = returnHandler.getTabledata();

                        DefaultTableModel model = (DefaultTableModel) view.getModel();

                        model.setRowCount(0); //Zurücksetzen der Tabelle

                        model.setColumnIdentifiers(columnname);
                        for (Object[] row : tabledatas) {
                            model.addRow(row);
                        }
                    } else {
                        Main.getManager().writeStatement(new SQLCommand(tf.getText()));
                    }
                }
            }
        });
        panel.add(label);
        panel.add(tf);
        panel.add(send);
        panel.add(check);

        setVisible(true);

        frame = new JDialog ();
        frame.setTitle("Set Connection");
        frame.setLocationRelativeTo(null);
        frame.setModal(true);
        frame.getContentPane().add (connectionpanel);
        frame.pack();

        connectionpanel.getButton1().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Choose Connection Config");

                int userselection = fileChooser.showOpenDialog(frame);

                File configfile = null;

                ConnectionData data = null;

                if(userselection == JFileChooser.APPROVE_OPTION){
                    configfile = fileChooser.getSelectedFile();
                    try {
                        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
                        mapper.findAndRegisterModules();
                        data = mapper.readValue(configfile, ConnectionData.class);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null,"Etwas ist schief gelaufen :(","ERROR", JOptionPane.ERROR_MESSAGE);
                    }

                    Main.getManager().setConnection(data);
                    JOptionPane.showMessageDialog(null,"Connection wurde erfolgreich gesetzt!","Connection", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                }
            }
        });

        connectionpanel.getJcomp1().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(connectionpanel.getHost().getText().equals("") ||
                        connectionpanel.getUser().getText().equals("") ||
                        connectionpanel.getPasswordField().getPassword().equals("") ||
                        connectionpanel.getHost().getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Mindestens ein Textfeld ist leer!","ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                ConnectionData data = new ConnectionData(connectionpanel.getHost().getText(),
                        connectionpanel.getUser().getText(),
                        connectionpanel.getPasswordField().getText(),
                        Integer.parseInt(connectionpanel.getPort().getText()));
                Main.getManager().setConnection(data);
                if(connectionpanel.getJcomp2().isSelected()){
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setDialogTitle("Specify a file to save");

                    int userSelection = fileChooser.showSaveDialog(frame);

                    File fileToSave;

                    if (userSelection == JFileChooser.APPROVE_OPTION) {
                        fileToSave = fileChooser.getSelectedFile();
                        System.out.println("Save as file: " + fileToSave.getAbsolutePath());
                        ObjectMapper mapper = new ObjectMapper(new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));
                        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
                        try {
                            mapper.writeValue(fileToSave, data);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        frame.dispose();
                    }
                }
                JOptionPane.showMessageDialog(null,"Connection wurde erfolgreich gesetzt!","Connection", JOptionPane.INFORMATION_MESSAGE);
            }
        });

    }
}
