package richard.mysqltest.mysql.handler;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ReturnHandler {
    void loopNext(ResultSet set) throws SQLException;
    void run(ResultSet set) throws SQLException;
}
