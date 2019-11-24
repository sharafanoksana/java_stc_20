/**
 * @author Sharafan Oksana
 * @date 21.11.2019
 * @package lesson8
 */
package lesson8;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 20100515;
    public String name;
    public int age;
    public double height;
    public boolean married;


    public Person(String name, int age, double height, boolean married) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.married = married;

    }
}
