/**
 * @author Sharafan Oksana
 * @date 10.12.2019
 * @package lesson15.DataBaseTables
 */
package lesson15.DataBaseTables;

import lesson15.ConnectionManager.ConnectionManager;
import lesson15.ConnectionManager.ConnectionManagerJdbcImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class LogsDaoJdbc {
    final String SQL_INSERT_LOGS = "INSERT INTO USERS(date_log, log_level, message_log, exception_log) VALUES(?,?,?,?)";
    private static ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();

    public boolean createLogsTable() {
        try (Connection connection = connectionManager.getConnection();) {
            Statement statement = connection.createStatement();
            statement.execute(
                    "create TABLE logdb" +
                            "(\n" +
                            "    id                 serial primary KEY,\n" +
                            "    date_log           DATE not null,\n" +
                            "    log_level          VARCHAR(15) not null,\n" +
                            "    message_log        VARCHAR(250) not null,\n" +
                            "    exception_log      VARCHAR(100) not null\n" +
                            ");\n"
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
