package richard.mysqltest.mysql;

import java.sql.*;

public class MySQLManager {

    private String host;
    private String username;
    private String password;
    private int port;

    private Connection connection;

    public MySQLManager(String host, String username, String password, int port){
        this.host = host;
        this.username = username;
        this.password = password;
        this.port = port;
    }

    public String setConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://"
                    + host + ":"
                    + port + "/"
                    + "mysql"
                    + "?serverTimezone=UTC",
                    username,
                    password);
            return "MySQL Verbindung Erfolgreich!\n";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Fehlgeschlagen! siehe Stack Trace";
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public ResultSet writeStatement(SQLCommand command) {
        Statement stmt = null;
        ResultSet set = null;

        try {

            stmt = connection.createStatement();
            if(command.isReturning()){
                set = stmt.executeQuery(command.getCommand());
                while(set.next()){
                    command.getHandler().run(set);
                }
            } else {
                stmt.execute(command.getCommand());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

        return set;

    }
}
