package richard.mysqltest.main;

import richard.mysqltest.gui.SQLFrame;
import richard.mysqltest.mysql.MySQLManager;
import richard.mysqltest.mysql.commands.SQLCommand;
import richard.mysqltest.mysql.handler.GetTableOutput;

public class Main {
    static MySQLManager manager;

    public static void main(String[] args) {
        manager = new MySQLManager(
                "localhost",
                "root",
                "project3627",
                3306
        );
        manager.setConnection();

        manager.writeStatement(new SQLCommand("use testing"));

        GetTableOutput out = new GetTableOutput();
        manager.writeStatement(new SQLCommand("describe user", out));

        SQLFrame sqlFrame = new SQLFrame(out.getTabledata(), out.getColumnname());
    }
}


