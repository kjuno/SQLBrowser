package richard.mysqltest.main;

import richard.mysqltest.gui.SQLFrame;
import richard.mysqltest.mysql.MySQLManager;
import richard.mysqltest.mysql.ReturnHandler;
import richard.mysqltest.mysql.SQLCommand;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class Main {
    static MySQLManager manager;
    static String[] columnname;
    static Object[][] tabledata;

    public static void main(String[] args) {
        manager = new MySQLManager(
                "localhost",
                "root",
                "project3627",
                3306
        );
        manager.setConnection();
        manager.writeStatement(new SQLCommand("use testing"));
        //manager.writeStatement(new SQLCommand("describe user"));
        manager.writeStatement(new SQLCommand("describe user", new ReturnHandler() {

            public void loopNext(ResultSet set) throws SQLException {
                for (int i = 0; i < columnname.length; i++) {
                    tabledata[set.getRow() - 1][i] = set.getString(columnname[i]);
                }
            }

            public void run(ResultSet set) throws SQLException {
                String[] strings = manager.convertMetaDatatoArray(set.getMetaData());
                Main.setColumnNames(strings);
                set.last();  // Moves the cursor to the last row in this ResultSet object.
                int rowCount = set.getRow();  //Retrieves the current row number.
                set.beforeFirst();
                tabledata = new Object[rowCount][columnname.length];
            }
        }));

        SQLFrame sqlFrame = new SQLFrame(tabledata, columnname);
        //for (int i = 0; i < tabledata.length; i++) {
        //        sqlFrame.getTable().setValueAt(tabledata[i][j], i + 1, j);
        //    }
        //}
    }

    private static void setColumnNames(String[] convertMetaDatatoArray) {
        columnname = convertMetaDatatoArray;
        if (columnname.length == 0){
            System.out.println("WTF?!");
        }
    }


}


