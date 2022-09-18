package de.kjuno.sqlbrowser.main;

import de.kjuno.sqlbrowser.mysql.MySQLManager;
import de.kjuno.sqlbrowser.gui.SQLFrame;

public class Main {

    static MySQLManager manager;

    public static void main(String[] args) {
        manager = new MySQLManager();
        new SQLFrame();
    }

    public static MySQLManager getManager() {
        return manager;
    }

}


