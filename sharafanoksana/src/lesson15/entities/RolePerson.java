/**
 * @author Sharafan Oksana
 * @date 07.12.2019
 * @package lesson15
 */
package lesson15.entities;

public class RolePerson {
    private int id;
    private String name;
    private String description;

    public RolePerson() {
    }

    public RolePerson(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public RolePerson(int id, String name, String description) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setKey(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RolePerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
