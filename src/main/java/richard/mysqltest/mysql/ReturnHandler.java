package richard.mysqltest.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ReturnHandler {
    void run(ResultSet set) throws SQLException;
}
