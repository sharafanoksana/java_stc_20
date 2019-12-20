/**
 * @author Sharafan Oksana
 * @date 05.12.2019
 * @package lesson15
 */
package lesson15.entities;

import java.sql.Date;

public class UserPerson {
    private int id;
    private String name;
    private Date birthday;
    private String login;
    private String city;
    private String email;
    private String description;

    public UserPerson(String name, Date birthday, String login, String city, String email, String description) {
        this.name = name;
        this.birthday = birthday;
        this.login = login;
        this.city = city;
        this.email = email;
        this.description = description;
    }

    public UserPerson(int id, String name, Date birthday, String login, String city, String email, String description) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKey(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", login='" + login + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
