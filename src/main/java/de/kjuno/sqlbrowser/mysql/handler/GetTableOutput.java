package de.kjuno.sqlbrowser.mysql.handler;

import de.kjuno.sqlbrowser.mysql.MySQLManager;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetTableOutput implements ReturnHandler {
    private Object[][] tabledata;

    private String[] columnname;

    public Object[][] getTabledata() {
        return tabledata;
    }

    public String[] getColumnname() {
        return columnname;
    }

    public void loopNext(ResultSet set) throws SQLException {
        for (int i = 0; i < columnname.length; i++) {
            tabledata[set.getRow() - 1][i] = set.getString(columnname[i]);
        }
    }

    public void run(ResultSet set) throws SQLException {
        columnname = MySQLManager.convertMetaDatatoArray(set.getMetaData());
        set.last();
        int rowCount = set.getRow();
        set.beforeFirst();
        tabledata = new Object[rowCount][columnname.length];
    }
}
