package richard.mysqltest.main;

import richard.mysqltest.gui.SQLFrame;
import richard.mysqltest.mysql.MySQLManager;

public class Main {
    static MySQLManager manager;
    public static boolean stopping;
    public static void main(String[] args) {
        manager = new MySQLManager(
                "localhost",
                "root",
                "project3627",
                3306
        );
        new SQLFrame();
    }
}


