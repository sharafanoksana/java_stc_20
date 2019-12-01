/**
 * @author Sharafan Oksana
 * @date 22.11.2019
 * @package lesson8
 */
package lesson08;

import java.io.Serializable;
import java.util.Random;

public class Pet {
    public int id;
    public String nickname;
    public int age;

    public Pet(String nickname, int age) {
        Random random = new Random();
        id = random.nextInt(1000);
        this.nickname = nickname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "{\n" +
                "       \"id\" : \"" + id + ",\n" +
                "       \"nickname : \"" + nickname + ",\n" +
                "       \"age\" : \"" + age + ",\n" +
                "       }";
    }

    public String toSerialaze() {
        String stId = "KEY : Pet.id\n     VALUE : " + id + "\n";
        String stNickname = "KEY : Pet.nickname\n     VALUE : " + nickname + "\n";
        String stAge = "KEY : Pet.age\n     VALUE : " + age + "\n";

        return stId + stNickname + stAge;
    }
}

