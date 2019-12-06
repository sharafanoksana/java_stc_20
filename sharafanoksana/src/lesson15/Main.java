/**
 * @author Sharafan Oksana
 * @date 03.12.2019
 * @package lesson15
 */
package lesson15;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
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
    public static void main(String[] args) {
        List<UserS> userSList = new ArrayList<>();
        userSList.add(new UserS("Timur", "1993-05-21", "green", "Казань", "timur93@gmail.com", "lkfsaghakdlhglashgd;ahs;g"));
        userSList.add(new UserS("Mira", "1989-04-07", "mira", "Иннополис", "mira89@gmail.com", "gdhga;lhg jldfjaslg;"));
        userSList.add(new UserS("Olga", "1998-05-21", "olga21", "Москва", "olga21@gmail.com", "galkglahg;lh jglajfd ghlj hj"));
        userSList.add(new UserS("Maya", "000-09-14", "pchela", "Киев", "MayaP4la@gmail.com", "gjladfgjja"));
        userSList.add(new UserS("Aleks", "1980-05-13", "ALEKS80", "Москвa", "ALEKSNOV@gmail.com", "ALGKH LAKGJ; DFJDLASKGA;"));
        userSList.add(new UserS("Luka", "1999-10-03", "Luka", "Mинск", "LukaO3V@gmail.com", "aklhg;ebn ,mcпфрыодвр"));

//        createTable();
//        insertTableRoles();
//        insertTableUsers_Roles();
        insertTableUsers(userSList);
    }

    private static void insertTableUsers(List<UserS> userSList) {

    }

    private static void insertTableUsersRoles() {

    }

    private static void insertTableRoles() {
        final String SQL_INSERT_ROLES = "INSERT INTO ROLES(name, description) VALUES(?,?)";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/lesson15",
                    "postgres",
                    "postgres");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_INSERT_ROLES);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setString(1, "Administration");
            preparedStatement.setString(2, "Aдминистратор");
            preparedStatement.setString(1, "Clients");
            preparedStatement.setString(2, "Клиент");
            preparedStatement.setString(1, "Billing");
            preparedStatement.setString(2, "Состояние счета");
            preparedStatement.executeUpdate(); //при изменении таблицы используем метод executeUpdate()
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/lesson15",
                    "postgres",
                    "postgres");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.execute(
//                    "drop table users_roles cascade ;\n" +
//                            "drop table roles;\n" +
//                            "drop table users;" +

                    "create TABLE users(\n" +
                            "    id          serial primary KEY,\n" +
                            "    name        VARCHAR(30) not NULL,\n" +
                            "    birthday    DATE,\n" +
                            "    login       VARCHAR(30) not null UNIQUE,\n" +
                            "    city        VARCHAR(30),\n" +
                            "    email       VARCHAR(50) not null,\n" +
                            "    description VARCHAR(255)\n" +
                            ");\n" +
                            "INSERT INTO users (name, birthday, login, city, email, description)" +
                            "VALUES\n" +
                            "('Timur1', '1993-05-21', 'green1', 'Казань', 'timur931@gmail.com', 'lkfsaghakdlhglashgd;ahs;g')," +
                            "('Mira1', '1989-04-07', 'mira1', 'Иннополис', 'mira891@gmail.com', 'gdhga;lhg jldfjaslg; ')," +
                            "('Olga1', '1998-05-21', 'olga211', 'Москва', 'olga211@gmail.com', 'galkglahg;lh jglajfd ghlj hj')," +
                            "('Aleks1', '1980-05-13', 'ALEKS801', 'Москва', 'ALEKSNOV1@gmail.com', 'ALGKH LAKGJ; DFJDLASKGA;')," +
                            "('Maya1', '2000-09-14', 'pchela1', 'Киев', 'MayaP4la1@gmail.com', 'gjladfgjja')," +
                            "('Luka1', '1999-10-03', 'Luka1', 'Минск', 'LukaO3V1@gmail.com', 'aklhg;ebn ,mcпфрыодвр');" +

                            "create TABLE roles\n" +
                            "(\n" +
                            "    id          serial primary KEY,\n" +
                            "    name        VARCHAR(15) not null UNIQUE,\n" +
                            "    description VARCHAR(255)\n" +
                            ");\n" +

                            "create TABLE users_roles\n" +
                            "(\n" +
                            "    id      serial primary KEY,\n" +
                            "    user_id int not null UNIQUE references users,\n" +
                            "    role_id int not null references roles\n" +
                            ");"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

