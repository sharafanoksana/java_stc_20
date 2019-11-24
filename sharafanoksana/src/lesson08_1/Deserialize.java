/**
 * @author Sharafan Oksana
 * @date 23.11.2019
 * @package lesson08_1
 */
package lesson08_1;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserialize {
    public static void main(String[] args)
            throws Exception
    {

        FileInputStream fis = new FileInputStream("person.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Person ted = (Person) ois.readObject();
        ois.close();

        System.out.println(ted);
    }
}
