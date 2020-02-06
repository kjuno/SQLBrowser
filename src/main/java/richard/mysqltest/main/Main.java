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

        if(!(manager.getConnection() == null)){
            manager.writeStatement(new SQLCommand("use testing"));
        }

        SQLFrame sqlFrame = new SQLFrame();
    }

    public static MySQLManager getManager() {
        return manager;
    }

}


