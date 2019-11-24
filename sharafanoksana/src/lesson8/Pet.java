/**
 * @author Sharafan Oksana
 * @date 22.11.2019
 * @package lesson8
 */
package lesson8;

import lesson05.Person;

import java.io.Serializable;
import java.util.Random;

public class Pet implements Serializable {
    private static final long serialVersionUID = 20100515;
    public int id;
    public String nickname;
    public int age;

    public Pet(String nickname, int age) {
        Random random = new Random();
        id = random.nextInt(1000);
        this.nickname = nickname;
        this.age = age;
    }
}

