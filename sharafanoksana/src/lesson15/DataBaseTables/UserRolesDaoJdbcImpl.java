/**
 * @author Sharafan Oksana
 * @date 07.12.2019
 * @package lesson15.DataBaseTables
 */
package lesson15.DataBaseTables;


import lesson15.ConnectionManager.ConnectionManager;
import lesson15.ConnectionManager.ConnectionManagerJdbcImpl;
import lesson15.Entities.UserPerson;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.*;

public class UserRolesDaoJdbcImpl implements UserRolesDao {
    private static final Logger logger = LogManager.getLogger(UserRolesDaoJdbcImpl.class);

    private static ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();

    @Override
    public boolean createUserRoleTable() {
        try (Connection connection = connectionManager.getConnection()) {

            Statement statement = connection.createStatement();
            statement.execute(
                    "create TABLE users_roles\n" +
                            "(\n" +
                            "    id      serial primary KEY,\n" +
                            "    user_id int not null UNIQUE references users,\n" +
                            "    role_id int not null references roles\n" +
                            ");"
            );
            logger.info("INFO | Cоздана таблица users_roles");
        } catch (SQLException e) {
            logger.throwing(Level.ERROR, new Throwable("WARNING"));
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean addUserRoles(UserPerson userPerson, int idRole) {
        final String SQL_INSERT_ROLES = "INSERT INTO USERS_ROLES(user_id, role_id) VALUES(?,?)";
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_ROLES);
            preparedStatement.setInt(1, userPerson.getId());
            preparedStatement.setInt(2, idRole);
            preparedStatement.executeUpdate(); //при изменении таблицы используем метод executeUpdate()
            logger.info("INFO | В таблицу users_roles занесены данные (users_id, roles_id) по " + userPerson.getName());
        } catch (SQLException e) {
            logger.throwing(Level.ERROR, new Throwable("WARNING"));
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateIdRolesInUsersRoles(UserPerson userPerson, int val) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE users_roles SET role_id=? " +
                            "WHERE user_id=?");
            preparedStatement.setInt(1, val);
            preparedStatement.setInt(2, userPerson.getId());
            preparedStatement.executeUpdate();
            logger.info("INFO");
            return true;
        } catch (SQLException e) {
            logger.throwing(Level.ERROR, new Throwable("WARNING"));
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUsersRolesById(Integer id) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM users_roles WHERE user_id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            logger.info("INFO | Удален пользователь в таблице users_roles по users_id " + id);
        } catch (SQLException e) {
            logger.throwing(Level.ERROR, new Throwable("WARNING"));;
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateIdRolesInUsersRolesBatch(int[] idUsers, int i) {
        try (Connection connection = connectionManager.getConnection()) {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE users_roles set role_id = ? where user_id = ?");
            for (int valId : idUsers){
                preparedStatement.setInt(1, i);
                preparedStatement.setInt(2, valId);
                preparedStatement.addBatch();
            }
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
            logger.info("INFO | В таблицу users_roles внесены изменения пакетом по данным (users_id, roles_id)");

            Savepoint savepoint2 = connection.setSavepoint("point2");//savepoint создание

            preparedStatement.setInt(1, 3);
            preparedStatement.setInt(2, 7);
            preparedStatement.executeUpdate();
            preparedStatement.setInt(1, 3);
            preparedStatement.setInt(2, 6);
            preparedStatement.executeUpdate();
            preparedStatement.setInt(1, 3);
            preparedStatement.setInt(2, 5);
            preparedStatement.executeUpdate();
            logger.info("INFO | В таблицу users_roles внесены изменения пакетом по данным (users_id, roles_id) " +
                    "с возможностью rollback(savepoint2)");
            connection.rollback(savepoint2);// откат до точки сохранения
            connection.commit();
            connection.close();
            return true;
        } catch (SQLException e) {
            logger.throwing(Level.ERROR, new Throwable("WARNING"));
            e.printStackTrace();
        }

        return false;
    }
}
