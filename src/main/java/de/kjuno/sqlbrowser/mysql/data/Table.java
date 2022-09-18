package de.kjuno.sqlbrowser.mysql.data;

public class Table {
    private String[] columnname;
    private Object[][] tabledata;

    public String[] getColumnname() {
        return columnname;
    }

    public void setColumnname(String[] columnname) {
        this.columnname = columnname;
    }

    public Object[][] getTabledata() {
        return tabledata;
    }

    public void setTabledata(Object[][] tabledata) {
        this.tabledata = tabledata;
    }

    public Table(String[] columnname, Object[][] tabledata) {
        this.columnname = columnname;
        this.tabledata = tabledata;
    }
}
