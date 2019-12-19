/**
 * @author Sharafan Oksana
 * @date 07.12.2019
 * @package lesson15.DataBaseTables
 */
package lesson15.dataBaseTables;


import lesson15.connectionManager.ConnectionManager;
import lesson15.connectionManager.ConnectionManagerJdbcImpl;
import lesson15.entities.UserPerson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.sql.*;

public class UserRolesDaoJdbcImpl implements UserRolesDao {
    public static final String SQL_INSERT_USERS_ROLES = "INSERT INTO USERS_ROLES(user_id, role_id) VALUES(?,?)";
    public static final String SQL_UPDATE_USERS_ROLES = "UPDATE users_roles SET role_id=? WHERE user_id=?";
    public static final String SQL_DELETE_USERS_ROLES = "DELETE FROM users_roles WHERE user_id=?";
    public static final String SQL_SELECT_USERS_ROLES = "SELECT * FROM users_roles WHERE user_id=?";
    public static final String SQL_SELECT_PERSON_ON_USERS_ROLES = "SELECT * FROM users WHERE id IN (SELECT user_id FROM users_roles WHERE role_id=?);";

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRolesDaoJdbcImpl.class);

    private static ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();

    public UserRolesDaoJdbcImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public UserRolesDaoJdbcImpl() {

    }

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
            LOGGER.info("INFO | Cоздана таблица users_roles");
        } catch (SQLException e) {
            LOGGER.error("Some thing wrong in createUserRoleTable method", e);
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean addUserRoles(UserPerson userPerson, int idRole) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_USERS_ROLES);
            preparedStatement.setInt(1, userPerson.getId());
            preparedStatement.setInt(2, idRole);
            preparedStatement.executeUpdate(); //при изменении таблицы используем метод executeUpdate()
            LOGGER.info("INFO | В таблицу users_roles занесены данные (users_id, roles_id) по " + userPerson.getName());
        } catch (SQLException e) {
            LOGGER.error("Some thing wrong in addUserRoles method", e);
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateIdRolesInUsersRoles(UserPerson userPerson, int val) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_USERS_ROLES);
            preparedStatement.setInt(1, val);
            preparedStatement.setInt(2, userPerson.getId());
            preparedStatement.executeUpdate();
            LOGGER.info("INFO");
            return true;
        } catch (SQLException e) {
            LOGGER.error("Some thing wrong in updateIdRolesInUsersRoles method", e);
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUsersRolesById(Integer id) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_USERS_ROLES);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            LOGGER.info("INFO | Удален пользователь в таблице users_roles по users_id " + id);
        } catch (SQLException e) {
            LOGGER.error("Some thing wrong in deleteUsersRolesById method", e);
            ;
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean selectIdRolesInUsersRoles(UserPerson userPerson) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_USERS_ROLES);
            preparedStatement.setInt(1, userPerson.getId());
            preparedStatement.executeUpdate();
            LOGGER.info("INFO | Выбраны данные для пользователь с id = " + userPerson.getId());
            return true;
        } catch (SQLException e) {
            LOGGER.error("Some thing wrong in selectIdRolesInUsersRoles method", e);
            e.printStackTrace();
        }
        return false;
    }
// todo  сделала выборку по заданному id_role

    /**
     * Метод выбирает пользователей по роли
     * @param id - id_role по которому будут выбраны все пользователи
     * @return возвращает пользователей с заданным id_role
     */
    @Override
    public UserPerson getIdRolesInUsersRoles(int id) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_PERSON_ON_USERS_ROLES);
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new UserPerson(
                                    resultSet.getInt(1),
                                    resultSet.getString(2),
                                    resultSet.getDate(3),
                                    resultSet.getString(4),
                                    resultSet.getString(5),
                                    resultSet.getString(6),
                                    resultSet.getString(7));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Some thing wrong in selectIdRolesInUsersRoles method", e);
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateIdRolesInUsersRolesBatch(int[] idUsers, int i) {
        try (Connection connection = connectionManager.getConnection()) {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE users_roles set role_id = ? where user_id = ?");
            for (int valId : idUsers) {
                preparedStatement.setInt(1, i);
                preparedStatement.setInt(2, valId);
                preparedStatement.addBatch();
            }
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
            LOGGER.info("INFO | В таблицу users_roles внесены изменения пакетом по данным (users_id, roles_id)");

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
            LOGGER.info("INFO | В таблицу users_roles внесены изменения пакетом по данным (users_id, roles_id) " +
                    "с возможностью rollback(savepoint2)");
            connection.rollback(savepoint2);// откат до точки сохранения
            connection.commit();
            connection.close();
            return true;
        } catch (SQLException e) {
            LOGGER.error("Some thing wrong in updateIdRolesInUsersRolesBatch method", e);
            e.printStackTrace();
        }

        return false;

    }

}
