/**
 * @author Sharafan Oksana
 * @date 07.12.2019
 * @package lesson15.DataBaseTables
 */
package test.lesson15.dataBaseTables;


import lesson15.connectionManager.ConnectionManager;
import lesson15.connectionManager.ConnectionManagerJdbcImpl;
import lesson15.dataBaseTables.UserPersonDao;
import lesson15.dataBaseTables.UserPersonDaoJdbcImpl;
import lesson15.dataBaseTables.UserRolesDao;
import lesson15.dataBaseTables.UserRolesDaoJdbcImpl;
import lesson15.entities.UserPerson;
import lesson15.service.DateHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import test.TestResultLoggerExtension;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

@ExtendWith(TestResultLoggerExtension.class)
class UserRolesDaoJdbcImplTest {
    private UserRolesDao userRolesDao;
    private ConnectionManager connectionManager;
    private Connection connection;
    private UserPersonDao userPersonDao;
    @Mock
    private PreparedStatement preparedStatement;

    /**
     * Создаем заглушки для JDBC
     */
    @BeforeEach
    void setUp() {
        initMocks(this);
        connectionManager = spy(ConnectionManagerJdbcImpl.getInstance());
        connection = mock(Connection.class);
        userRolesDao = new UserRolesDaoJdbcImpl(connectionManager);
    }

    @Test
    public void addUserRoles() throws SQLException {
        when(connectionManager.getConnection()).thenReturn(connection);
        doReturn(preparedStatement).when(connection).prepareStatement(UserRolesDaoJdbcImpl.SQL_INSERT_USERS_ROLES);
        int id = 100;
        String name = "Oleg";
        Date birthday = DateHelper.getDate("1980-04-27");
        String login = "oleg80";
        String city = "Казань";
        String email = "oleg80@gmail.com";
        String description = "hgagh;";
        UserPerson userOleg = new UserPerson(id, name, birthday, login, city, email, description);
        int idRole = 1;

        boolean result = userRolesDao.addUserRoles(userOleg, idRole);

        verify(connectionManager, times(1)).getConnection();
        verify(connection, times(1)).prepareStatement(UserRolesDaoJdbcImpl.SQL_INSERT_USERS_ROLES);
        verify(preparedStatement, times(1)).setInt(1, userOleg.getId());
        verify(preparedStatement, times(1)).setInt(2, idRole);
        verify(preparedStatement, times(1)).execute();
        assertTrue(result);
    }

    @Test
    public void addUserRolesWithSQLException() throws SQLException {
        when(connectionManager.getConnection()).thenReturn(connection);
        doReturn(preparedStatement).when(connection).prepareStatement(UserRolesDaoJdbcImpl.SQL_INSERT_USERS_ROLES);
        doThrow(new SQLException()).when(preparedStatement).execute();
        UserPerson userPerson = new UserPerson(
                1000, "Oleg1000", DateHelper.getDate("1980-04-27"), "oleg1000", "Казань", "oleg1000@gmail.com", "hgagh;");
        int idRole = 1;

        boolean result = assertDoesNotThrow(() -> userRolesDao.addUserRoles(userPerson, idRole));

        verify(connectionManager, times(1)).getConnection();
        verify(connection, times(1)).prepareStatement(UserRolesDaoJdbcImpl.SQL_INSERT_USERS_ROLES);
        verify(preparedStatement, atMost(2)).setInt(anyInt(), anyInt());
        verify(preparedStatement, times(1)).setInt(2, idRole);
        verify(preparedStatement, never()).executeQuery();
        verify(preparedStatement, times(1)).execute();
        assertFalse(result);
    }

    @Test
    void test1() {
        int result = connectionManager.get15();
        assertEquals(15, result);
    }

    @Test
    void test2() {
        when(connectionManager.get15()).thenAnswer(invocationOnMock -> ((int) invocationOnMock.callRealMethod()) + 5);
        int result = connectionManager.get15();
        assertEquals(20, result);
    }
}
