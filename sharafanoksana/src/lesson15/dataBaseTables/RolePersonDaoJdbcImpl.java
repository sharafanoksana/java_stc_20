/**
 * @author Sharafan Oksana
 * @date 07.12.2019
 * @package lesson15.DataBaseTables
 */
package lesson15.dataBaseTables;

import lesson15.connectionManager.ConnectionManager;
import lesson15.connectionManager.ConnectionManagerJdbcImpl;
import lesson15.entities.RolePerson;

import javax.ejb.EJB;
import javax.inject.Inject;
import java.sql.*;
import java.util.List;

@EJB
public class RolePersonDaoJdbcImpl implements RoleDao {
    public static final String SQL_INSERT_ROLES =
            "DROP TABLE IF EXISTS roles;\n" +
                    "create TABLE roles\n" +
                    "(\n" +
                    "    id          serial primary KEY,\n" +
                    "    name        VARCHAR(15) not null UNIQUE,\n" +
                    "    description VARCHAR(255)\n" +
                    ");\n"+
                    "alter table roles owner to postgres;";

    private ConnectionManager connectionManager;

    @Inject
    public RolePersonDaoJdbcImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public boolean addRole(RolePerson rolePerson) {
        return false;
    }

    @Override
    public RolePerson getRoleById(Integer id) {
        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM roles WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                RolePerson rolePerson = new RolePerson(
                        resultSet.getString(2),
                        resultSet.getString(3));
                rolePerson.setKey(resultSet.getInt(1));
                return rolePerson;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateRoleById(RolePerson person) {
        return false;
    }

    @Override
    public boolean deleteRoleById(Integer id) {
        return false;
    }

    public boolean insertAllRolesTable(List<RolePerson> listRoles) {
        final String SQL_INSERT_ROLES = "INSERT INTO ROLES(name, description) VALUES(?,?)";

        try (Connection connection = connectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_ROLES, Statement.RETURN_GENERATED_KEYS);
            for (RolePerson rolePerson : listRoles) {
                preparedStatement.setString(1, rolePerson.getName());
                preparedStatement.setString(2, rolePerson.getDescription());
                preparedStatement.executeUpdate(); //при изменении таблицы используем метод executeUpdate()
// присваиваем id каждому объекту RolePerson
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    rolePerson.setKey(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
