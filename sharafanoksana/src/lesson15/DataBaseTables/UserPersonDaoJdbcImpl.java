/**
 * @author Sharafan Oksana
 * @date 07.12.2019
 * @package lesson15.DataBaseTables
 */
package lesson15.DataBaseTables;

import lesson15.ConnectionManager.ConnectionManager;
import lesson15.ConnectionManager.ConnectionManagerJdbcImpl;
import lesson15.Entities.UserPerson;

import java.sql.*;

public class UserPersonDaoJdbcImpl implements UserPersonDao {
    final String SQL_INSERT_USERS = "INSERT INTO USERS(name, birthday, login, city, email, description) VALUES(?,?,?,?,?,?)";
    private static ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();

    @Override
    public boolean createUserTable() {
        try (Connection connection = connectionManager.getConnection();) {
            Statement statement = connection.createStatement();
            statement.execute(
                    "create TABLE users(\n" +
                            "    id          serial primary KEY,\n" +
                            "    name        VARCHAR(30) not NULL,\n" +
                            "    birthday    DATE,\n" +
                            "    login       VARCHAR(30) not null UNIQUE,\n" +
                            "    city        VARCHAR(30),\n" +
                            "    email       VARCHAR(50) not null,\n" +
                            "    description VARCHAR(255)\n" +
                            ");\n"
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean addUser(UserPerson person) {
        final String SQL_INSERT_USERS = "INSERT INTO USERS(name, birthday, login, city, email, description) VALUES(?,?,?,?,?,?)";
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
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public UserPerson getUserById(Integer id) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE id = ?");
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
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public boolean updateUserById(UserPerson person) {
        return false;
    }

    @Override
    public boolean deleteUserById(Integer id) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM users WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
