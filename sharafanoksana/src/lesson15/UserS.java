/**
 * @author Sharafan Oksana
 * @date 05.12.2019
 * @package lesson15
 */
package lesson15;

import java.util.Date;

public class UserS {
    private String name;
    private String birthday;
    private String login;
    private String city;
    private String email;
    private String description;

    public UserS(String name, String birthday, String login, String city, String email, String description) {
        this.name = name;
        this.birthday = birthday;
        this.login = login;
        this.city = city;
        this.email = email;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
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
}
