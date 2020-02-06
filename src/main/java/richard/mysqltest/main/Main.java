package richard.mysqltest.main;

import richard.mysqltest.gui.SQLFrame;
import richard.mysqltest.mysql.MySQLManager;

public class Main {

    static MySQLManager manager;

    public static void main(String[] args) {
        manager = new MySQLManager();
        SQLFrame sqlFrame = new SQLFrame();
    }

    public static MySQLManager getManager() {
        return manager;
    }

}


