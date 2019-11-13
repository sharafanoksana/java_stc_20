/**
 * @author Sharafan Oksana
 * @date 11.11.2019
 * @package lesson05
 */
package lesson05;

import java.util.Objects;
import java.util.Random;

public class Pet {
    final private int id;
    private String nickname;
    private Person owner;
    private double weight;

    public Pet(String nickname, Person owner, double weight) {
        Random random = new Random();
        id = random.nextInt(1000);
        this.nickname = nickname;
        this.owner = owner;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public Person getOwner() {
        return owner;
    }

    public double getWeight() {
        return weight;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return id == pet.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", owner=" + owner +
                ", weight=" + weight +
                '}';
    }
}
