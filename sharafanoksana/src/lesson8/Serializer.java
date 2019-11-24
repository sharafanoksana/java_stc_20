/**
 * @author Sharafan Oksana
 * @date 21.11.2019
 * @package lesson8
 */
package lesson8;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Serializer extends ClassLoader {

    /**
     * Методы выполняют сериализацию объекта Object в файл file
     *
     * @param object
     * @param file
     */
    void serialize(Object object, String file) throws NoSuchFieldException {

        Class<? extends Object> objectClass = object.getClass();
        Field[] fields = objectClass.getDeclaredFields();// Метод возвращает все объявленные переменные в классе.
        for (Field field : fields) {
            System.out.println(field);
            String name = field.getName();
            System.out.println(name);
            Class<?> type = field.getType();
            System.out.println(type);
//            field.setAccessible(true);// метод позволяет избежать исключение IllegalAccessException
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(file);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Методы выполняют десериализацию объекта из этого файла
     *
     * @param file
     * @return
     */
    Object deSerialize(String file) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName(file);
        Object object = clazz.newInstance();
        Person p = (Person) object;

//        try(ObjectInputStream ois = new ObjectInputStream(
//                new FileInputStream(file))) {
//            p = (Person)ois.readObject();
////            Pet c = (Pet)ois.readObject();
//            System.out.printf("Человека зовут: %s , его возраст: %d , его рост: %f метров, женат/замужем: %b",
//                    p.name, p.age, p.height, p.married
//
//            );
//        }
//        catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }
        System.out.println(p);
        System.out.printf("Человека зовут: %s , его возраст: %d , его рост: %f метров, женат/замужем: %b",
                p.name, p.age, p.height, p.married);
        return p;
    }

//    @Override
//    public Class<?> loadClass(String name) throws ClassNotFoundException {
//        if ("KindMagic".equals(name)) {
//            return findClass(name);
//        }
//        return super.loadClass(name);
//    }
//
//    @Override
//    protected Class<?> findClass(String name) throws ClassNotFoundException {
//        System.out.println("findClass starts work: " + name);
//        if ("KindMagic".equals(name)) {
//            try {
//                byte[] bytes = Files.readAllBytes(Paths.get(file));
//                return defineClass(name, bytes, 0, bytes.length);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return super.findClass(name);
//    }
}
