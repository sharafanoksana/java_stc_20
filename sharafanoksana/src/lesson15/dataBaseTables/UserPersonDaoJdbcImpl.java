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

import javax.ejb.EJB;
import javax.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@EJB
public class UserPersonDaoJdbcImpl implements UserPersonDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserPersonDaoJdbcImpl.class);
    public static final String SQL_INSERT_USERS =
            "DROP TABLE IF EXISTS users;\n" +
                    "create TABLE users(\n" +
                    "    id          serial primary KEY,\n" +
                    "    name        VARCHAR(30) not NULL,\n" +
                    "    birthday    DATE,\n" +
                    "    login       VARCHAR(30) not null UNIQUE,\n" +
                    "    city        VARCHAR(30),\n" +
                    "    email       VARCHAR(50) not null,\n" +
                    "    description VARCHAR(255)\n" +
                    ");\n" +
                    "\n" +
                    "alter table users owner to postgres;";

    private static final String SELECT_ALL_FROM_USERS = "SELECT * FROM users";
    private static final String UPDATE_USERS =
            "UPDATE users SET " +
                    "name=?, " +
                    "birthday=?, " +
                    "login=?, " +
                    "city=?, " +
                    "email=?, " +
                    "description=? " +
                    "WHERE id=?";
    private static final String SELECT_FROM_USERS = "SELECT * FROM users WHERE id = ?";
    private static final String DELETE_FROM_USER = "DELETE FROM users WHERE id=?";

    private ConnectionManager connectionManager;

    @Inject
    public UserPersonDaoJdbcImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public UserPersonDaoJdbcImpl() {

    }

    @Override
    public boolean addUser(UserPerson person) {
        try (Connection connection = connectionManager.getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_USERS, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, person.getName());
            preparedStatement.setDate(2, person.getBirthday());
            preparedStatement.setString(3, person.getLogin());
            preparedStatement.setString(4, person.getCity());
            preparedStatement.setString(5, person.getEmail());
            preparedStatement.setString(6, person.getDescription());
            preparedStatement.executeUpdate();
            
            // присваиваем id каждому объекту UserPerson
            ResultSet rs = preparedStatement.getGeneratedKeys();
            //берем id из таблицы User, который был присвоен при заполнении таблицы каждому юзеру и вставляем
            // в объект UserPerson
            if (rs.next()) {
                person.setKey(rs.getInt(1));
            }
        } catch (SQLException e) {
            LOGGER.error("Some thing wrong in addUser method", e);
            return false;
        }
        return true;
    }

    @Override
    public UserPerson getUserById(Integer id) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_USERS);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                UserPerson userPerson = new UserPerson(
                        resultSet.getString(2),
                        resultSet.getDate(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7));
                userPerson.setKey(resultSet.getInt(1));
                return userPerson;
            }
        } catch (SQLException e) {
            LOGGER.error("Some thing wrong in getUserById method", e);
        }
        return null;
    }
    @Override
    public boolean updateUserById(UserPerson person) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS)) {
            preparedStatement.setString(1, person.getName());
            preparedStatement.setDate(2, person.getBirthday());
            preparedStatement.setString(3, person.getLogin());
            preparedStatement.setString(4, person.getCity());
            preparedStatement.setString(5, person.getEmail());
            preparedStatement.setString(6, person.getDescription());
            preparedStatement.setInt(7, person.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            LOGGER.error("Some thing wrong in updateUserById method", e);
        }
        return false;
    }

    @Override
    public boolean deleteUserById(Integer id) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_USER);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("Some thing wrong in deleteUserById method", e);
            return false;
        }
        return true;
    }

    @Override
    public Collection<UserPerson> getAllUserPerson() {
        List<UserPerson> listUserPerson = new ArrayList<>();
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FROM_USERS);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                listUserPerson.add(new UserPerson(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDate(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7)
                ));
            }
            return listUserPerson;
        } catch (SQLException e) {
            LOGGER.error("Some thing wrong in getAllUserPerson method", e);
        }
        return new ArrayList<>();
    }
}
