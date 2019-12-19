/**
 * @author Sharafan Oksana
 * @date 14.12.2019
 * @package test
 */
package test;

import lesson15.Main;
import lesson15.connectionManager.ConnectionManager;
import lesson15.connectionManager.ConnectionManagerJdbcImpl;
import lesson15.dataBaseTables.UserRolesDao;
import lesson15.dataBaseTables.UserRolesDaoJdbcImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainTest.class);

    private Main main;
    private UserRolesDao userRolesDao;
    private ConnectionManager connectionManager;
    private Object UserRolesDao;

    @BeforeEach
    void setUp() {
        LOGGER.trace("BeforeEach in MainTest");
        main = new Main();
        connectionManager = ConnectionManagerJdbcImpl.getInstance();
        userRolesDao = new UserRolesDaoJdbcImpl(connectionManager);
    }

    @BeforeAll
    static void tearDownAll() {
        LOGGER.info("BeforeAll in MainTest");
    }

    @AfterAll
    static void setUpAll() {
        LOGGER.info("AfterAll in MainTest");
    }

    @AfterEach
    void tearDown() {
        LOGGER.info("AfterEach in MainTest");
    }

    @Test
    void main() {
        assertDoesNotThrow(() -> main.method1((lesson15.dataBaseTables.UserRolesDao) UserRolesDao));
    }

    @Test
    void mainWithException() {
        assertThrows(NullPointerException.class, () -> main.method1(null));
    }

}
