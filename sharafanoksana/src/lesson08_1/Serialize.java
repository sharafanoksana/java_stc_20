/**
 * @author Sharafan Oksana
 * @date 23.11.2019
 * @package lesson08_1
 */
package lesson08_1;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Serialize {
    public static void main(String[] args)
            throws Exception
    {
        Person person = new Person("Максим","Оксана",35);
        PersonProxy personProxy = new PersonProxy(person);

        FileInputStream fis = new FileInputStream("C:\\Users\\sharafan\\IdeaProjects\\java_stc_20\\person.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Person ted = (Person) ois.readObject();
        ois.close();

        System.out.println(ted);
    }
}
