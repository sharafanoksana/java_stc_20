/**
 * @author Sharafan Oksana
 * @date 26.11.2019
 * @package lesson08.task1
 */
package lesson08_1.task011;

import lesson08.Person;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SimpleSerialaze {
    public void serialize(Object object, String file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new
                FileOutputStream(file))) {
            oos.writeObject(object);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Object deSerialize(String file) {
        Person p = new Person();
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file))) {
            p = (Person) ois.readObject();
            System.out.println(p.toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }
}
