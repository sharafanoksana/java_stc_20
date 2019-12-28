/**
 * @author Sharafan Oksana
 * @date 03.12.2019
 * @package lesson15
 */
package lesson15;

import lesson15.dataBaseTables.*;
import lesson15.entities.RolePerson;
import lesson15.entities.UserPerson;
import lesson15.service.DateHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * 1)    Спроектировать базу
 * -      Таблица USER содержит поля id, name, birthday, login_ID, city, email, description
 * -      Таблица ROLE содержит поля id, name (принимает значения Administration, Clients, Billing), description
 * -      Таблица USER_ROLE содержит поля id, user_id, role_id
 * Типы полей на ваше усмотрению, возможно использование VARCHAR(255)
 * 2)      Через jdbc интерфейс сделать запись данных(INSERT) в таблицу
 * a)      Используя параметризированный запрос
 * b)      Используя batch процесс
 * 3)      Сделать параметризированную выборку по login_ID и name одновременно
 * 4)      Перевести connection в ручное управление транзакциями
 * a)      Выполнить 2-3 SQL операции на ваше усмотрение (например, Insert в 3 таблицы – USER, ROLE, USER_ROLE)
 * между sql операциями установить логическую точку сохранения(SAVEPOINT)
 * б)   Выполнить 2-3 SQL операции на ваше усмотрение (например, Insert в 3 таблицы – USER, ROLE, USER_ROLE)
 * между sql операциями установить точку сохранения (SAVEPOINT A), намеренно ввести некорректные
 * данные на последней операции, что бы транзакция откатилась к логической точке SAVEPOINT A
 */
public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
//
//    public static void main(String[] args) throws ParseException {
//        List<UserPerson> userPersonList = new ArrayList<>();
//
//        userPersonList.add(new UserPerson("Max", DateHelper.getDate("1978-08-21"), "Billing", "Казань", "timur93@gmail.com", "lkfsaghakdlhglashgd;ahs;g"));
//        userPersonList.add(new UserPerson("Mira", DateHelper.getDate("1989-04-07"), "mira", "Иннополис", "mira89@gmail.com", "gdhga;lhg jldfjaslg;"));
//        userPersonList.add(new UserPerson("Olga", DateHelper.getDate("1998-05-21"), "olga21", "Москва", "olga21@gmail.com", "galkglahg;lh jglajfd ghlj hj"));
//        userPersonList.add(new UserPerson("Maya", DateHelper.getDate("1991-11-12"), "pchela", "Киев", "MayaP4la@gmail.com", "gjladfgjja"));
//        userPersonList.add(new UserPerson("Aleks", DateHelper.getDate("1980-05-13"), "ALEKS80", "Москвa", "ALEKSNOV@gmail.com", "ALGKH LAKGJ; DFJDLASKGA;"));
//        userPersonList.add(new UserPerson("Luka", DateHelper.getDate("1999-10-03"), "Luka", "Mинск", "LukaO3V@gmail.com", "aklhg;ebn ,mcпфрыодвр"));
//        userPersonList.add(new UserPerson("Mark", DateHelper.getDate("1989-03-03"), "Admin", "Казань", "Admin@gmail.com", "iojhablkndfb;"));
//
//        List<RolePerson> listRoles = new ArrayList<>();
//        listRoles.add(new RolePerson("Administration", "Aдминистратор"));
//        listRoles.add(new RolePerson("Clients", "Клиент"));
//        listRoles.add(new RolePerson("Billing", "Состояние счета"));
//
//
////        createTable();
//        insertTableRoles(listRoles);
//        insertTableUsers(userPersonList);
//        insertIdInTableUsersRoles(userPersonList);
//        updateTableUsersRoles(1,1);
//        int[] idUser ={2,3,4};
//        // здесь же использую SavePoint и перевежу connection в ручное управление транзакциями
//        updateTableUsersRolesBatch(idUser, 3);
//
//    }
//
//    private static void updateTableUsersRolesBatch(int[] idUser, int i) {
//        UserRolesDaoJdbcImpl userRolesDaoJdbc = new UserRolesDaoJdbcImpl();
//        System.out.println("Внесены изменения в таблицу users_roles для поля role_id для пользователей " +
//                "с заданным значение id в массиве: " + userRolesDaoJdbc.updateIdRolesInUsersRolesBatch(idUser, i));
//    }
//
//    private static void updateTableUsersRoles(int id,int val) {
//        UserRolesDaoJdbcImpl userRolesDaoJdbc = new UserRolesDaoJdbcImpl();
//        UserPersonDaoJdbcImpl userPersonDaoJdbc = new UserPersonDaoJdbcImpl();
//        UserPerson person = userPersonDaoJdbc.getUserById(id);
//            System.out.println("id:" + person.getId() + " " + person.getName() +
//                    " роль пользователя в таблице USERS_ROLES изменена:  "
//                    + userRolesDaoJdbc.updateIdRolesInUsersRoles(person, val));
//    }
//
//    private static void insertIdInTableUsersRoles(List<UserPerson> userPersonList) {
//        UserRolesDaoJdbcImpl userRolesDaoJdbc = new UserRolesDaoJdbcImpl();
//        for (UserPerson userPerson : userPersonList) {
//            System.out.println(userPerson.getId() + " " + userPerson.getName() +
//                    " пользователя добавлено в таблицу USERS_ROLES " + userRolesDaoJdbc.addUserRoles(userPerson, 2));
//        }
//    }
//
//    private static void insertTableUsers(List<UserPerson> userPersonList) {
//        UserPersonDaoJdbcImpl db = new UserPersonDaoJdbcImpl();
//        for (UserPerson user : userPersonList) {
//            db.addUser(user);
//            System.out.println(user.getName() + " - добавлена в таблицу USERS: id="
//                    + user.getId());
//        }
//    }
//
//    private static void insertTableRoles(List<RolePerson> listRoles) {
//        RolePersonDaoJdbcImpl rolesDb = new RolePersonDaoJdbcImpl();
//        System.out.println("Таблица roles заполнена значениями: " + rolesDb.insertAllRolesTable(listRoles));
//    }
//
//    public static void createTable() {
//        LogsDaoJdbc logsDaoJdbc = new LogsDaoJdbc();
//        System.out.println("табица logs создана: " + logsDaoJdbc.createLogsTable());
//
//        UserPersonDaoJdbcImpl userPersonDaoJdbc = new UserPersonDaoJdbcImpl();
//        System.out.println("табица user создана: " + userPersonDaoJdbc.createUserTable());
//
//        RolePersonDaoJdbcImpl rolePersonDaoJdbc = new RolePersonDaoJdbcImpl();
//        System.out.println("табица role создана: " + rolePersonDaoJdbc.createRoleTable());
//
//        UserRolesDaoJdbcImpl userRoleDaoJdbc = new UserRolesDaoJdbcImpl();
//        System.out.println("табица userRole создана: " + userRoleDaoJdbc.createUserRoleTable());
//    }
//
//// todo здесь что-то не так ( !!! этот метод не отрабатывает долджным образом, т.к. без добавления пользователя
////  в таблицу юзеров происходит: ОШИБКА: INSERT или UPDATE в таблице "users_roles" нарушает ограничение внешнего ключа
////  "users_roles_user_id_fkey"
//
    public void method1(UserRolesDao userRolesDao, UserPerson userPerson) {
        UserPersonDao userPersonDao = new UserPersonDaoJdbcImpl();
        userPersonDao.addUser(userPerson); //при раскометрировании строки юзер записывается в таблицу "users_roles" и тест проходит успешно
        userRolesDao.addUserRoles(userPerson, 1);
        userPerson = userRolesDao.getIdRolesInUsersRoles(1);
        LOGGER.info("Начальный объект: {}", userPerson);
            userPerson.setCity("10000");
        userRolesDao.updateIdRolesInUsersRoles(userPerson, 1);
        userPerson = userRolesDao.getIdRolesInUsersRoles(1);
        LOGGER.info("Итоговый объект: {}", userPerson);
    }
}

